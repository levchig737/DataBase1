package GUI;

import TableEntity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReceptionController implements Initializable {
    @FXML
    public Label lblDoctorName;
    @FXML
    public Label lblSpecial;
    @FXML
    public Label lblDataWork;
    @FXML
    public TableView<ReceptionWithNamePatient> receptionTable;
    @FXML
    public TableColumn<ReceptionWithNamePatient, String> txtReceptionDate;
    @FXML
    public TableColumn<ReceptionWithNamePatient, String> txtReceptionTime;
    @FXML
    public TableColumn<ReceptionWithNamePatient, String> txtReceptionRoom;
    @FXML
    public TableColumn<ReceptionWithNamePatient, String> txtPatientFullName;
    @FXML
    public TableColumn<ReceptionWithNamePatient, String> txtReceptionResult;


    public MainModel mainModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Устанавливаем данные выбранного доктора
        lblDoctorName.setText(mainModel.getSelectedDoctor().getTxtDoctorName());
        lblSpecial.setText(mainModel.getSelectedDoctor().getTxtSpecialist());
        lblDataWork.setText(mainModel.getSelectedDoctor().getDatDoctorWork().toString());

        // Установка данных в таблицу
        txtReceptionDate.setCellValueFactory(new PropertyValueFactory<>("txtReceptionDate"));
        txtReceptionTime.setCellValueFactory(new PropertyValueFactory<>("txtReceptionTime"));
        txtReceptionRoom.setCellValueFactory(new PropertyValueFactory<>("txtReceptionRoom"));
        txtPatientFullName.setCellValueFactory(new PropertyValueFactory<>("txtPatientFullName"));
        txtReceptionResult.setCellValueFactory(new PropertyValueFactory<>("txtReceptionResult"));

        // Создаем список для загрузки в TableView
        ObservableList<ReceptionWithNamePatient> receptionFXList = FXCollections.observableArrayList();

        // Выполняем соединение таблиц
        mainModel.connectReceptionWithPatient();

        // Добавление данных
        receptionFXList.addAll(mainModel.receptionWithPatient);
        receptionTable.setItems(receptionFXList);

        // Выставляем ширину столбцов на всю ширину таблицы
        receptionTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        txtReceptionDate.setMaxWidth(70.0);
        txtReceptionDate.setMinWidth(80.0);
        txtReceptionRoom.setMaxWidth(100.0);
        txtReceptionRoom.setMinWidth(50.0);
        txtReceptionTime.setMaxWidth(70.0);
        txtReceptionTime.setMinWidth(50.0);
        txtPatientFullName.setMaxWidth(250.0);
        txtPatientFullName.setMinWidth(200.0);
    }

    @FXML
    private void onAddReception(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-reception.fxml"));

        NewReceptionController controller = new NewReceptionController();
        controller.mainModel = mainModel;
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1100, 600);

//        stage.setResizable(false); // Запрет на изменения окна
        stage.setTitle("Добавить прием");
        stage.setScene(scene);

        // Закрываем прошлое окно
        stage.show();
        ((Stage)((Node) actionEvent.getSource()).getScene().getWindow()).close();

    }
    @FXML
    private void onCancel(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("doctor-view.fxml"));

        DoctorController controller = new DoctorController();
        controller.mainModel = mainModel;
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 400);

//        stage.setResizable(false); // Запрет на изменения окна
        stage.setTitle("Доктора");
        stage.setScene(scene);

        // Закрываем прошлое окно
        stage.show();
        ((Stage)((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }

}
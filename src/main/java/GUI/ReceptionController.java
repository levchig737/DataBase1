package GUI;

import TableEntity.*;
import TableEntity.Reception;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
        txtReceptionResult.setMaxWidth(400.0);
        txtReceptionResult.setMinWidth(350.0);
    }

    @FXML
    private void handleClick(MouseEvent event){
    }

}
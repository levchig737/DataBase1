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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class NewReceptionController implements Initializable {
    @FXML
    public Label lblDoctorName;
    @FXML
    public Label lblSpecial;
    @FXML
    public ComboBox<String> txtPatientName;
    @FXML
    public DatePicker txtReceptionDate;
    @FXML
    public TextField txtReceptionTime;
    @FXML
    public ComboBox<Integer> txtReceptionRoom;
    @FXML
    public TextField txtReceptionResult;

    public MainModel mainModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDoctorName.setText(mainModel.getSelectedDoctor().getTxtDoctorName());
        lblSpecial.setText(mainModel.getSelectedDoctor().getTxtSpecialist());

        // Установка выпадающих списков
        ObservableList<String> patientNameList = mainModel.patientList.stream()
                .map(Patient::getFullPatientName)
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        txtPatientName.setItems(patientNameList);

        ObservableList<Integer> receptionRoomList = mainModel.receptionList.stream()
                .map(Reception::getReceptionRoom)
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        txtReceptionRoom.setItems(receptionRoomList);

    }

    @FXML
    private void onAddReception(ActionEvent actionEvent){


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
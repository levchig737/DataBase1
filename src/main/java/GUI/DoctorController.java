package GUI;

import GUI.MainModel;
import TableEntity.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class DoctorController {
    @FXML
    public TableView<Doctor> doctorTable;
    @FXML
    public TableColumn <Doctor, String> txtDoctorName;
    @FXML
    public TableColumn <Doctor, String> txtSpecialist;
    @FXML
    public TableColumn<Doctor, String> datDoctorWork;

    public MainModel mainModel;

    public void initialize() {
        txtDoctorName.setCellValueFactory(new PropertyValueFactory<>("txtDoctorName"));
        txtSpecialist.setCellValueFactory(new PropertyValueFactory<>("txtSpecialist"));
        datDoctorWork.setCellValueFactory(new PropertyValueFactory<>("datDoctorWork"));

        // Загрузка данных
        mainModel = new MainModel();
        ObservableList<Doctor> doctorFXList = FXCollections.observableArrayList();
        mainModel.loadDoctor();

        // Добавление данных
        doctorFXList.addAll(mainModel.doctorList);
        doctorTable.setItems(doctorFXList);
    }
    @FXML
    public void onAddDoctorButtonClick(ActionEvent actionEvent) {

    }

    public void onCancelButtonClick(ActionEvent actionEvent) {
    }
}
package GUI;

import GUI.MainModel;
import TableEntity.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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
        ObservableList<Doctor> doctorFXList = FXCollections.observableArrayList();
        mainModel.loadDoctor();

        // Добавление данных
        doctorFXList.addAll(mainModel.doctorList);
        doctorTable.setItems(doctorFXList);
    }
    @FXML
    public void onAddDoctorButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-doctor.fxml"));

        NewDoctorController controller = new NewDoctorController();
        controller.mainModel = mainModel;
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 400);

        stage.setTitle("Добавить доктора");
        stage.setScene(scene);

        stage.showAndWait();
    }

    public void onCancelButtonClick(ActionEvent actionEvent) {
    }
}
package GUI;

import TableEntity.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;
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
        txtDoctorName.setCellValueFactory(new PropertyValueFactory<Doctor, String>("txtDoctorName"));
        txtSpecialist.setCellValueFactory(new PropertyValueFactory<Doctor,String>("txtSpecialist"));
        datDoctorWork.setCellValueFactory(new PropertyValueFactory<Doctor,String>("datDoctorWork"));

        // Загрузка данных
        mainModel = new MainModel();
        List<Doctor> doctor4List = mainModel.loadDoctor();

        // Добавление данных
        ObservableList<Doctor> doctorList = FXCollections.observableArrayList();
        doctorList.add(new Doctor("Герасименко Марк Сергеевич", "Стоматолог", new Date(1010101010)));
        doctorList.add(new Doctor("Власова Ангелина Алексевна", "Терапевт", new Date(102123123)));
        doctorTable.setItems(doctorList);
        doctorTable.setTableMenuButtonVisible(false);

    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
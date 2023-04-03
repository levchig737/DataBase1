package GUI;

import TableEntity.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashMap;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    public TableView<Doctor> mainTable;
    @FXML
    public TableColumn <Doctor, String> columnFIO;
    @FXML
    public TableColumn <Doctor, String> columnDateBirthday;
    @FXML
    public TableColumn<Doctor, String> columnAddress;

    public javafx.collections.ObservableList<Doctor> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        columnFIO.setCellValueFactory(new PropertyValueFactory<Doctor, String>("txtFIO"));
        columnDateBirthday.setCellValueFactory(new PropertyValueFactory<Doctor,String>("dateBirthday"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<Doctor,String>("txtAddress"));
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
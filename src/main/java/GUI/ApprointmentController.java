package GUI;

import GUI.MainModel;
import TableEntity.Doctor;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ApprointmentController implements Initializable {
    @FXML
    public Label lblDoctorName;
    @FXML
    public Label lblSpecial;
    @FXML
    public Label lblDataWork;

    public MainModel mainModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDoctorName.setText(mainModel.getSelectedDoctor().getTxtDoctorName());
    }

}
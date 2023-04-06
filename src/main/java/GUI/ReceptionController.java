package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceptionController implements Initializable {
    @FXML
    public Label lblDoctorName;
    @FXML
    public Label lblSpecial;
    @FXML
    public Label lblDataWork;

    public MainModel mainModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Устанавливаем данные выбранного доктора
        lblDoctorName.setText(mainModel.getSelectedDoctor().getTxtDoctorName());
        lblSpecial.setText(mainModel.getSelectedDoctor().getTxtSpecialist());
        lblDataWork.setText(mainModel.getSelectedDoctor().getDatDoctorWork().toString());
    }

}
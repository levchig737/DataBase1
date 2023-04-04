package GUI;

import TableEntity.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    public MainModel mainModel = new MainModel();
    public void initialize() {

    }

    public void onOpenDoctorForm(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("doctor-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 400);

//        stage.setResizable(false); // Запрет на изменения окна
        stage.setScene(scene);

        stage.showAndWait();
    }

    public void onOpenAppointmentForm(ActionEvent actionEvent) {
    }
}
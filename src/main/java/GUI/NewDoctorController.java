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

public class NewDoctorController implements Initializable {
    @FXML
    public TextField textFieldDoctorName;
    @FXML
    public TextField textFieldSpecial;
    @FXML
    public DatePicker dataPickerWork;

    public MainModel mainModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Кнопка "Добавить доктора"
     * @param actionEvent нажатие на кнопку
     * @throws IOException Ошибка какая-то
     */
    @FXML
    public void onAddDoctor(ActionEvent actionEvent) throws IOException {
        String name = textFieldDoctorName.getText();
        String special = textFieldSpecial.getText();
        LocalDate localDataWork = dataPickerWork.getValue();

        // Преобразуем дату в тип Date
        Date dataWork = Date.from(localDataWork.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Doctor newDoctor = new Doctor(name, special, dataWork);

        // Добавляем доктора в БД
        this.mainModel.addDoctor(newDoctor);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
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
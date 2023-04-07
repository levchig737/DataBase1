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
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
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
    int intReceptionId;
    int intDoctorId;
    int intPatientId;

    private Date datReceptionDate;
    private String ReceptionTime;
    private String ReceptionRoom;
    private String ReceptionResult;

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

    /**
     * Кнопка получения и ввода данных в БД
     * @param actionEvent событие нажатия кнопки
     */
    @FXML
    private void onAddReception(ActionEvent actionEvent){
        intDoctorId = mainModel.getSelectedDoctor().getIntDoctorId();

        datReceptionDate = java.util.Date.from(txtReceptionDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        ReceptionTime = txtReceptionTime.getText();
        ReceptionResult = txtReceptionResult.getText();

        Reception reception = new Reception(intDoctorId, intPatientId, datReceptionDate, ReceptionTime,
                ReceptionRoom, ReceptionResult);
        this.mainModel.addReception(reception);
    }

    @FXML
    private void onSetReceptionRoom(ActionEvent actionEvent) {
        ReceptionRoom = txtReceptionRoom.getSelectionModel().getSelectedItem().toString();
    }

    /**
     * Получает выбранного пациента, получает его id.
     * @param actionEvent событие Выбора пациента
     */
    @FXML
    private void onSetPatientName(ActionEvent actionEvent) {
        String patientName = txtPatientName.getSelectionModel().getSelectedItem();

        // Получаем индекс пацинета
        intPatientId = mainModel.getPatientId(patientName);
        if (intPatientId < 0){
            System.err.println("Not exists patient");
            throw new RuntimeException();
        }
    }

    @FXML
    private void onCancel(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reception-view.fxml"));

        ReceptionController controller = new ReceptionController();
        controller.mainModel = mainModel;
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1100, 600);

        stage.setTitle("Прием");
        stage.setScene(scene);

        stage.show();
        ((Stage)((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }
}
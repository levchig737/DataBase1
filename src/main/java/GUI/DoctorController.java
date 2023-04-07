package GUI;

import TableEntity.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Doctor selectedDoctor;

    /**
     * Инициализация таблицы TableView
     */
    public void initialize() {
        txtDoctorName.setCellValueFactory(new PropertyValueFactory<>("txtDoctorName"));
        txtSpecialist.setCellValueFactory(new PropertyValueFactory<>("txtSpecialist"));
        datDoctorWork.setCellValueFactory(new PropertyValueFactory<>("datDoctorWork"));

        // Создаем список для загрузки в TableView
        ObservableList<Doctor> doctorFXList = FXCollections.observableArrayList();

        // Добавление данных
        doctorFXList.addAll(mainModel.doctorList);
        doctorTable.setItems(doctorFXList);

        // Выставляем ширину столбцов на всю ширину таблицы
        doctorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    /**
     * Кнопка "Добавить доктора" из формы с TableView
     * @param actionEvent нажатая кнопка
     * @throws IOException ошибка
     */
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

        stage.show();
        ((Stage)((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }

    /**
     * Возвращаемся к прошлому окну HelloApplication и закрываем нынешнее
     * @param actionEvent это окно
     * @throws IOException ошибка
     */
    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        // Открываем прошлое окно
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

        HelloController controller = new HelloController();
        controller.mainModel = mainModel;
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 400);

//        stage.setResizable(false); // Запрет на изменения окна
        stage.setTitle("Изменение данных db22207");
        stage.setScene(scene);

        // Закрываем прошлое окно
        stage.show();
        ((Stage)((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }

    /**
     * Вызываем форму при нажатии на строку доктора
     * @param event событие
     */
    @FXML
    private void handleClick(KeyEvent event) throws IOException {
        // Обработка щелчка мыши на таблице
        if (event.getCode() != KeyCode.ENTER) return;

        selectedDoctor = doctorTable.getSelectionModel().getSelectedItem();
        if (selectedDoctor == null) return;


        // Выполнение действия, которое необходимо при выборе ячейки таблицы
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reception-view.fxml"));

        ReceptionController controller = new ReceptionController();
        mainModel.setSelectedDoctor(selectedDoctor);
        controller.mainModel = mainModel;
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1100, 600);

        stage.setTitle("Прием");
        stage.setScene(scene);

        stage.show();
        ((Stage)((Node) event.getSource()).getScene().getWindow()).close();
    }
}
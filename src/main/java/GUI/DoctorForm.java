package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Устаревшая Форма. Осталась для примера, не используется в приложении
 */
public class DoctorForm extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DoctorForm.class.getResource("doctor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 400);

        // Минимальные размеры окна
        stage.setMinWidth(400);
        stage.setMinHeight(300);

        stage.setTitle("Доктора");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
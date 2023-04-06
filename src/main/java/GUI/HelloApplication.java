package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Начальное окно форма Доктора
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        HelloController controller = new HelloController();
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 400);

        // Минимальные размеры окна
        stage.setMinWidth(400);
        stage.setMinHeight(300);

        stage.setTitle("Изменение данных db22207");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
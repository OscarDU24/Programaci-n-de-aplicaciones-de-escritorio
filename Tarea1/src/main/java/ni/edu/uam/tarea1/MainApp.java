package ni.edu.uam.tarea1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("login.fxml")
            );
            Scene scene = new Scene(loader.load(), 400, 400);
            primaryStage.setTitle("Registro de Clases");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        public static void main(String[] args) {
            launch(args);
        }

}

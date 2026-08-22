package ni.edu.uam.tarea1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private void abrirRegistroClase() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("clase.fxml")
            );
            Scene scene = new Scene(loader.load(), 450, 450);
            Stage stage = new Stage();
            stage.setTitle("Registrar Clase");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void verClases() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("verRegistros.fxml")
            );
            Scene scene = new Scene(loader.load(), 650, 450);
            Stage stage = new Stage();
            stage.setTitle("Clases Registradas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cerrarSesion() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("login.fxml")
            );
            Scene scene = new Scene(loader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
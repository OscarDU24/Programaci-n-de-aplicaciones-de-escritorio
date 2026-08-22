package ni.edu.uam.tarea1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblMensaje;
    @FXML
    private void iniciarSesion() {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        if (usuario.isEmpty() || password.isEmpty()) {
            lblMensaje.setText("Ingrese sus datos");
        } else if (usuario.equals("admin") && password.equals("1234")) {
            abrirMenu();
        } else {
            lblMensaje.setText("Usuario o contraseña incorrectos");
        }
    }
    private void abrirMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("menu.fxml")
            );
            Scene scene = new Scene(loader.load(), 400, 400);
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setTitle("Menú Principal");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
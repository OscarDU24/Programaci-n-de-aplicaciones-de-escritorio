package ni.edu.uam.tarea1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClaseController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtProfesor;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtAula;
    @FXML
    private Label lblMensaje;
    @FXML
    private void registrarClase() {

        String nombre = txtNombre.getText();
        String profesor = txtProfesor.getText();
        String fecha = txtFecha.getText();
        String aula = txtAula.getText();

        if (nombre.isEmpty() ||
                profesor.isEmpty() ||
                fecha.isEmpty() ||
                aula.isEmpty()) {
            lblMensaje.setText("Complete todos los campos");
            return;
        }
        Clase nuevaClase = new Clase(
                nombre,
                profesor,
                fecha,
                aula
        );
        Datos.clases.add(nuevaClase);
        lblMensaje.setText("Clase registrada correctamente");
        limpiarCampos();
    }
    private void limpiarCampos() {
        txtNombre.clear();
        txtProfesor.clear();
        txtFecha.clear();
        txtAula.clear();
    }
    @FXML
    private void volverMenu() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }
}
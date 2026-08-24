package org.example.tarea;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField txtCarnet;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCarrera;
    @FXML
    private TextField txtSemestre;

    @FXML
    private TableView<Estudiante> tabla;
    @FXML
    private TableColumn<Estudiante, String> colCarnet;
    @FXML
    private TableColumn<Estudiante, String> colNombre;
    @FXML
    private TableColumn<Estudiante, String> colApellido;
    @FXML
    private TableColumn<Estudiante, String> colCarrera;
    @FXML
    private TableColumn<Estudiante, String> colSemestre;

    private final ObservableList<Estudiante> lista = FXCollections.observableArrayList();

    private Estudiante estudianteSeleccionado = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colCarnet.setCellValueFactory(new PropertyValueFactory<>("Carnet"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("Carrera"));
        colSemestre.setCellValueFactory(new PropertyValueFactory<>("Semestre"));
        tabla.setItems(lista);

    // Cuando el usuario hace clic en una fila, se cargan sus datos en los campos de texto
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, anterior, nuevo) -> {
        if (nuevo != null) {
            estudianteSeleccionado = nuevo;
            txtCarnet.setText(nuevo.getCarnet());
            txtNombre.setText(nuevo.getNombre());
            txtApellido.setText(nuevo.getApellido());
            txtCarrera.setText(nuevo.getCarrera());
            txtSemestre.setText(nuevo.getSemestre());
        }
    });
}

@FXML
private void agregarEstudiante() {
    if (!camposValidos()) return;

    boolean existe = lista.stream().anyMatch(e -> e.getCarnet().equalsIgnoreCase(txtCarnet.getText().trim()));
    if (existe) {
        mostrarAlerta("Carnet duplicado", "Ya existe un estudiante con ese carnet.");
        return;
    }

    lista.add(new Estudiante(
            txtCarnet.getText().trim(),
            txtNombre.getText().trim(),
            txtApellido.getText().trim(),
            txtCarrera.getText().trim(),
            txtSemestre.getText().trim()
    ));
    limpiarCampos();
}

@FXML
private void editarEstudiante() {
    if (estudianteSeleccionado == null) {
        mostrarAlerta("Sin selección", "Selecciona en la tabla el estudiante que quieres editar.");
        return;
    }
    if (!camposValidos()) return;

    estudianteSeleccionado.setCarnet(txtCarnet.getText().trim());
    estudianteSeleccionado.setNombre(txtNombre.getText().trim());
    estudianteSeleccionado.setApellido(txtApellido.getText().trim());
    estudianteSeleccionado.setCarrera(txtCarrera.getText().trim());
    estudianteSeleccionado.setSemestre(txtSemestre.getText().trim());

    // Refresca la tabla para que se vean los cambios (los setters no lo notifican solos)
    tabla.refresh();

    limpiarCampos();
    estudianteSeleccionado = null;
}

@FXML
private void eliminarEstudiante() {
    Estudiante seleccionado = tabla.getSelectionModel().getSelectedItem();
    if (seleccionado == null) {
        mostrarAlerta("Sin selección", "Selecciona en la tabla el estudiante que quieres eliminar.");
        return;
    }
    lista.remove(seleccionado);
    limpiarCampos();
    estudianteSeleccionado = null;
}

private boolean camposValidos() {
    if (txtCarnet.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty()
            || txtApellido.getText().trim().isEmpty() || txtCarrera.getText().trim().isEmpty()
            || txtSemestre.getText().trim().isEmpty()) {
        mostrarAlerta("Campos incompletos", "Por favor llena todos los campos.");
        return false;
    }
    return true;
}

private void limpiarCampos() {
    txtCarnet.clear();
    txtNombre.clear();
    txtApellido.clear();
    txtCarrera.clear();
    txtSemestre.clear();
    tabla.getSelectionModel().clearSelection();
}

private void mostrarAlerta(String titulo, String mensaje) {
    Alert alerta = new Alert(Alert.AlertType.WARNING);
    alerta.setTitle(titulo);
    alerta.setHeaderText(null);
    alerta.setContentText(mensaje);
    alerta.showAndWait();
}}



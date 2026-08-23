package org.example.registroestudiante;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private TextField txtCarnet;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCarrera;

    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> colCarnet;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableColumn<Estudiante, String> colApellido;

    @FXML
    private TableColumn<Estudiante, String> colCarrera;

    private ObservableList<Estudiante> estudiantes =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colCarnet.setCellValueFactory(
                new PropertyValueFactory<>("carnet"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colApellido.setCellValueFactory(
                new PropertyValueFactory<>("apellido"));

        colCarrera.setCellValueFactory(
                new PropertyValueFactory<>("carrera"));

        tablaEstudiantes.setItems(estudiantes);

        tablaEstudiantes.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, anterior, seleccionado) -> {

                    if (seleccionado != null) {
                        txtCarnet.setText(seleccionado.getCarnet());
                        txtNombre.setText(seleccionado.getNombre());
                        txtApellido.setText(seleccionado.getApellido());
                        txtCarrera.setText(seleccionado.getCarrera());
                    }
                });
    }

    @FXML
    private void ingresarEstudiante() {

        if (camposVacios()) {
            return;
        }

        Estudiante estudiante = new Estudiante(
                txtCarnet.getText(),
                txtNombre.getText(),
                txtApellido.getText(),
                txtCarrera.getText()
        );

        estudiantes.add(estudiante);

        limpiarCampos();
    }

    @FXML
    private void editarEstudiante() {

        Estudiante seleccionado =
                tablaEstudiantes.getSelectionModel().getSelectedItem();

        if (seleccionado == null || camposVacios()) {
            return;
        }

        seleccionado.setCarnet(txtCarnet.getText());
        seleccionado.setNombre(txtNombre.getText());
        seleccionado.setApellido(txtApellido.getText());
        seleccionado.setCarrera(txtCarrera.getText());

        tablaEstudiantes.refresh();

        limpiarCampos();
    }

    @FXML
    private void eliminarEstudiante() {

        Estudiante seleccionado =
                tablaEstudiantes.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            return;
        }

        estudiantes.remove(seleccionado);

        limpiarCampos();
    }

    @FXML
    private void limpiarCampos() {

        txtCarnet.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtCarrera.clear();

        tablaEstudiantes.getSelectionModel().clearSelection();
    }

    private boolean camposVacios() {

        return txtCarnet.getText().isEmpty()
                || txtNombre.getText().isEmpty()
                || txtApellido.getText().isEmpty()
                || txtCarrera.getText().isEmpty();
    }
}
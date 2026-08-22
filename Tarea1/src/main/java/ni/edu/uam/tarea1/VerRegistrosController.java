package ni.edu.uam.tarea1;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class VerRegistrosController {

    @FXML
    private TableView<Clase> tablaClases;
    @FXML
    private TableColumn<Clase, String> colNombre;
    @FXML
    private TableColumn<Clase, String> colProfesor;
    @FXML
    private TableColumn<Clase, String> colFecha;
    @FXML
    private TableColumn<Clase, String> colAula;
    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );
        colProfesor.setCellValueFactory(
                new PropertyValueFactory<>("profesor")
        );
        colFecha.setCellValueFactory(
                new PropertyValueFactory<>("fecha")
        );
        colAula.setCellValueFactory(
                new PropertyValueFactory<>("aula")
        );
        tablaClases.getItems().addAll(Datos.clases);
    }
    @FXML
    private void volverMenu() {
        Stage stage = (Stage) tablaClases.getScene().getWindow();
        stage.close();
    }
    
}

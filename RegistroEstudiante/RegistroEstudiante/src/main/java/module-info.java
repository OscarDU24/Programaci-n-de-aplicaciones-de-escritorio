module org.example.registroestudiante {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.registroestudiante to javafx.fxml;
    exports org.example.registroestudiante;
}
module com.example.practicaparaexamen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicaparaexamen to javafx.fxml;

    opens com.example.practicaparaexamen.controllers to javafx.fxml;

    exports com.example.practicaparaexamen;
    exports com.example.practicaparaexamen.controllers;
    exports com.example.practicaparaexamen.modelos;
}
module com.example.practicaparaexamen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicaparaexamen to javafx.fxml;
    exports com.example.practicaparaexamen;
}
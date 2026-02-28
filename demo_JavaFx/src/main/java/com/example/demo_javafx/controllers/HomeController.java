package com.example.demo_javafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {

    @FXML
    private Label Bienvenida;
    public void recibirNombre(String nombre) {
        Bienvenida.setText("Bienvenido a Home, " + nombre);
    }
}
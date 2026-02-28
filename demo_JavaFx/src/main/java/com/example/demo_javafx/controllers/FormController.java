package com.example.demo_javafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FormController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtEdad;

    @FXML
    private Label lblResulatado;
    @FXML
    private Button dashboard;
    @FXML
    private Label Bienvenida;


    public void onValidate(ActionEvent event) {

        String nombre = txtNombre.getText() == null ? "" : txtNombre.getText();
        String correo = txtCorreo.getText() == null ? "" : txtCorreo.getText();
        String paswords = txtEdad.getText() == null ? "" : txtEdad.getText();


        List<String> errores = new ArrayList<>();//Listado de Strings
        if (nombre.trim().isEmpty() || nombre.isBlank() || nombre.length() < 4) {
            errores.add("El usuario no cuenta con el minimo de charts");


        }
        if (correo.trim().isEmpty() || correo.isBlank() || !correo.contains("@") || !correo.contains(".")) {
            errores.add(" El correo es incorrecto");
        }

        try {

            if (paswords.length() < 6) {
                errores.add("La contraseña debe tener al  6 caracteres");
            }
        } catch (Exception e) {
            errores.add("El dato es numerico");
        }
        if (errores.isEmpty()) {
            lblResulatado.setText("Los datos son correctos");
            lblResulatado.setStyle("-fx-text-fill: green");
            dashboard.setVisible(true);
            dashboard.setManaged(true);
        } else {
            String datos = "";
            for (String dato : errores) {
                datos += dato;
            }
            lblResulatado.setText(datos);
            lblResulatado.setStyle("-fx-text-fill: red");
            dashboard.setVisible(false);
            dashboard.setManaged(false);
        }

    }

    public void onGotoForDashboard(ActionEvent event) {
        try {
            String nombreUsuario = txtNombre.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_javafx/home-view.fxml"));
            Scene formScene = new Scene(loader.load(), 350, 580);
            HomeController homeController = loader.getController();
            homeController.recibirNombre(nombreUsuario);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(formScene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//Ejemplo del profe
        /* try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_javafx/home-view.fxml"));
            Scene formScene = new Scene(loader.load(),350,580);
            Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(formScene);
            stage.show();

        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
*/

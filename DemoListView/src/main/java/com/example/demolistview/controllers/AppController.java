package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;
    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonServices service = new PersonServices();

    @FXML//Ejecuta al inicio en cuanto se cargue el controller
    public void initialize(){
        //Inicializar ListView
        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            loadDataToForm(newValue);//String con el valor del repo 0 test-email0gmail
        });
        listView.setItems(data);

    }
    @FXML
    public void onAddPerson(){
        try{
            String name=txtName.getText();
            String email = txtEmail.getText();
            String edad=txtEdad.getText();
            service.addPerson(name,email,edad);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            lblMsg.setText("Persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
    @FXML
    public void onUpdate(){
        int index=listView.getSelectionModel().getSelectedIndex();
        String name=txtName.getText();
        String email=txtEmail.getText();
        String edad=txtEdad.getText();
        try{
            service.updatePerson(index,name,email,edad);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            lblMsg.setText("Persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");

        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");

        }catch (IllegalArgumentException ex){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForList();
            data.setAll(items);
            lblMsg.setText("Datos cargados Exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    private void loadDataToForm(String item){

        String[] items = item.split(",");
        txtName.setText(items[0]);//Corresponde a la parte del nombre
        txtEmail.setText(items[1]);//Corresponde a la parte del email
        txtEdad.setText(items[2]);//Corresponde a la parte de edad
    }
}

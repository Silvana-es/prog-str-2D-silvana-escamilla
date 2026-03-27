package com.example.practicaparaexamen.controllers;

import com.example.practicaparaexamen.modelos.Contacto;
import com.example.practicaparaexamen.services.PersonService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private ComboBox<String> cmbParentesco;

    @FXML
    private ListView<Contacto> listView;

    @FXML
    private Label lblMsg;

    private PersonService service = new PersonService();

    String[] parentescos = {"Padre", "Madre", "Hermano", "Hermana",
            "Abuelo",
            "Abuela",
            "Tío",
            "Tía"
    };

    @FXML
    public void initialize(){

        cmbParentesco.getItems().addAll(parentescos);

        listView.setItems(service.obtenerLista());

        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldVal,newVal)->{

                    if(newVal != null){

                        txtNombre.setText(newVal.getNombre());
                        txtTelefono.setText(newVal.getTelefono());
                        cmbParentesco.setValue(newVal.getParentesco());

                    }

                }
        );
    }

    @FXML
    public void agregar(){

        try{

            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String parentesco = cmbParentesco.getValue();

            if(parentesco == null){
                throw new IllegalArgumentException("Seleccione un parentesco");
            }

            service.agregarContacto(nombre,telefono,parentesco);

            limpiar();

            lblMsg.setText("Contacto agregado correctamente");

        }catch(Exception e){
            lblMsg.setText(e.getMessage());
        }

    }

    @FXML
    public void buscar(){

        String nombre = txtNombre.getText();

        Contacto con = service.buscarContacto(nombre);

        if(con != null){

            txtTelefono.setText(con.getTelefono());
            cmbParentesco.setValue(con.getParentesco());

            lblMsg.setText("Contacto encontrado");

        }else{

            lblMsg.setText("Contacto no encontrado");

        }

    }

    @FXML
    public void actualizar(){

        try{

            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String parentesco = cmbParentesco.getValue();

            service.actualizarContacto(nombre,telefono,parentesco);

            listView.refresh();

            limpiar();

            lblMsg.setText("Contacto actualizado");

        }catch(Exception e){
            lblMsg.setText(e.getMessage());
        }

    }

    @FXML
    public void eliminar(){

        try{

            String nombre = txtNombre.getText();

            service.eliminarContacto(nombre);

            limpiar();

            lblMsg.setText("Contacto eliminado");

        }catch(Exception e){
            lblMsg.setText(e.getMessage());
        }

    }

    @FXML
    public void limpiar(){

        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);

    }

}
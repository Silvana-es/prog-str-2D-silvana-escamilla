package com.example.practicaparaexamen.services;
import com.example.practicaparaexamen.modelos.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonService {

    private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

    public ObservableList<Contacto> obtenerLista(){
        return listaContactos;
    }

    public void agregarContacto(String nombre, String telefono, String parentesco){

        validarDatos(nombre,telefono);

        if(existeNombre(nombre)){
            throw new IllegalArgumentException("Ya existe un contacto con ese nombre");
        }

        Contacto nuevo = new Contacto(nombre,telefono,parentesco);
        listaContactos.add(nuevo);
    }

    public Contacto buscarContacto(String nombre){

        for(Contacto con : listaContactos){
            if(con.getNombre().equalsIgnoreCase(nombre.trim())){
                return con;
            }
        }

        return null;
    }

    public void actualizarContacto(String nombre,String telefono,String parentesco){

        Contacto con = buscarContacto(nombre);

        if(con == null){
            throw new IllegalArgumentException("Contacto no encontrado");
        }

        validarDatos(nombre,telefono);

        con.setTelefono(telefono);
        con.setParentesco(parentesco);
    }

    public void eliminarContacto(String nombre){

        Contacto con = buscarContacto(nombre);

        if(con == null){
            throw new IllegalArgumentException("Contacto no encontrado");
        }

        listaContactos.remove(con);
    }

    public boolean existeNombre(String nombre){

        for(Contacto con : listaContactos){
            if(con.getNombre().equalsIgnoreCase(nombre.trim())){
                return true;
            }
        }

        return false;
    }

    public void validarDatos(String nombre,String telefono){

        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");

        }

        if(telefono == null || telefono.isBlank()){
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }

        if(telefono.length() != 10){
            throw new IllegalArgumentException("El teléfono debe tener 10 dígitos");
        }
    }

}
package com.example.demolistview.services;

import com.example.demolistview.repositores.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {
    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForList() throws IOException {
        List<String> lines = repo.readAllLines(); //Recupera las lineas de archivo
        List<String> result = new ArrayList<>();//Listado de resultado con el formato deseado
        for (String line : lines){
            if (line==null || line.isBlank()) continue; //Ignora las lineas nulas

            String[] parts = line.split(",", -1);
            String name = parts[0].trim(); // Obtiee el nombre del arreglo
            String correo = parts[1].trim(); //Obtiene el correo del arreglo
            result.add(name+"-"+correo);//Se agrega a la lista de resultados con el formato
        }
        return result;
    }
    public void addPerson(String name, String email) throws IOException {
        validarPerson(name,email);
        String nameNoComa = name.replace(",", " ");
        String emailNoComa= email.replace(",","");

        repo.appendNewLine(nameNoComa + "," + emailNoComa);
    }
    private void validarPerson(String name, String email) {
        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre no cumple con los estándares");
        }

        String em = (email == null) ? "" : email.trim();

        if (em.isBlank() || !em.contains("@") || !em.contains(".")) {
            throw new IllegalArgumentException("El correo es incorrecto");

        }
    }
}

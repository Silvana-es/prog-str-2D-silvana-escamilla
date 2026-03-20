package com.example.demolistview.services;

import com.example.demolistview.repositores.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {
    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForList() throws IOException {
        List<String> lines = repo.readAllLines(); //Recupera las lineas del archivo
        List<String> result = new ArrayList<>();//Listado de resultado con el formato deseado
        for (String line : lines){
            if (line==null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);
            String name = parts[0].trim(); // Obtiene el nombre
            String correo = parts[1].trim(); //Obtiene el correo
            String edad = parts[2].trim();
            result.add(name + " - " + correo + " - " + edad);//Se agrega a la lista de resultados con el formato
        }
        return result;
    }

    public List<String> loadDataForListBusqueda(String busqueda) throws IOException {
        List<String> lines = repo.readAllLines(); //Recupera las lineas del archivo
        List<String> result = new ArrayList<>();//Listado de resultado con el formato deseado
        for (String line : lines){
            if (line==null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);
            String name = parts[0].trim(); // Obtiene el nombre
            String correo = parts[1].trim(); //Obtiene el correo
            if(!correo.contains(busqueda)) continue;
            String edad = parts[2].trim();
            result.add(name + " - " + correo + " - " + edad);//Se agrega a la lista de resultados con el formato
        }
        return result;
    }


    public void addPerson(String name, String email, String edad) throws IOException {
        validarPerson(name,email,edad);
        String nameNoComa = name.replace(",", "");
        String emailNoComa= email.replace(",","");
        String edadNoComa= edad.replace(",", "");

        repo.appendNewLine(nameNoComa + "," + emailNoComa + "," + edadNoComa + "\n");
    }
    public void updatePerson(int index,String name, String email, String edad) throws IOException {
        List<String> lines = repo.readAllLines();
        if(index == -1){
            throw new IllegalArgumentException("El indice recibido es invalido");
        }
        lines.set(index, name + "," + email + "," + edad);
        repo.appendNewLines(lines);
    }
    public void deletePerson(int index) throws IOException {
        List<String> lines = repo.readAllLines();
        lines.remove(index);
        repo.appendNewLines(lines);
    }
    private List<String> getAllCleanLines()throws IOException{
        List<String> lines=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : lines){
            if (line==null && line.isBlank()){
                cleanLines.add(line);
            }
        }
        return cleanLines;
    }
    private void validarPerson(String name, String email, String edad) {
        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }

        String em = (email == null) ? "" : email.trim();

        if (em.isBlank() || !em.contains("@") || !em.contains(".")) {
            throw new IllegalArgumentException("El correo es incorrecto");

        }
        int edadNum;
        try {
            edadNum = Integer.parseInt(edad);
            if (edadNum < 18) {
                throw new IllegalArgumentException("Solo se permiten mayores de edad");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser numerica");
        }


    }
}

package com.example.demolistview.repositores;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PersonFileRepository {
    // Se guardara dentro de la carpeta "data" con el nombre persons.csv
    private final Path filePath = Paths.get("data", "persons.csv");

    // Metodo que verifica que el archivo y la carpeta existan
    private void ensureFileExist() throws IOException {

        // Si la carpeta "data" no existe, se crea
        if(Files.notExists(filePath.getParent())){
            Files.createDirectories(filePath.getParent());
        }

        // Si el archivo persons.csv no existe, se crea
        if(Files.notExists(filePath)){
            Files.createFile(filePath);
        }
    }

    // Metodo para leer todas las lineas del archivo
    public List<String> readAllLines() throws IOException {
        ensureFileExist(); // Primero verifica que el archivo exista
        return Files.readAllLines(filePath, StandardCharsets.UTF_8); // Lee el archivo y devuelve una lista de lineas
    }

    // Metodo para agregar una nueva línea al archivo
    public void appendNewLine(String line) throws IOException {

        // Escribe una nueva linea al final del archivo sin borrar las anteriores
        Files.writeString(filePath, line + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}

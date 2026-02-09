import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        GradeService gradeService = new GradeService();
        InputValidator input = new InputValidator();

        // INPUT
        String nombre = input.leerTextoNoVacio(sc, "Ingresa el nombre del alumno:");

        double p1 = input.leerDoubleEnRango(sc, "Ingresa parcial 1:", 0, 100);
        double p2 = input.leerDoubleEnRango(sc, "Ingresa parcial 2:", 0, 100);
        double p3 = input.leerDoubleEnRango(sc, "Ingresa parcial 3:", 0, 100);

        int asistencia = input.leerIntEnRango(sc, "Ingresa asistencia (%):", 0, 100);

        boolean entregoProyecto = input.leerBoolean(sc, "¿Entrego proyecto? (true/false):");

        double promedio = gradeService.calcularPromedio(p1, p2, p3);
        double finalCalificacion = gradeService.calcularFinal(promedio, asistencia);
        String estado = gradeService.determinarEstado(finalCalificacion, asistencia, entregoProyecto);

        // OUTPUT
        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, finalCalificacion, estado);
    }
    public static void imprimirReporte(String nombre, double p1, double p2, double p3, double promedio, int asistencia, boolean entregoProyecto, double finalCalificacion, String estado) {

        System.out.println("REPORTE FINAL");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parcial 1: " + p1);
        System.out.println("Parcial 2: " + p2);
        System.out.println("Parcial 3: " + p3);
        System.out.println("Promedio parciales: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entrego proyecto: " + entregoProyecto);
        System.out.println("Calificacion final: " + finalCalificacion);
        System.out.println("Estado: " + estado);

    }
}

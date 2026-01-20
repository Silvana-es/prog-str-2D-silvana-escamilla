import java.util.Scanner;

    public class Main {
    public  static double RANGO_BAJO=18.5;
    public  static double RANGO_MEDIO=25;
    public  static double RANGO_ALTO=30;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double pesok = obtenerDouble(scanner, "Ingrese el peso en Kilogramos -> 80:");
        double alturaM = obtenerDouble(scanner, "Ingrese la altura en Metros -> 1.80:");
        double imc = calcularImc(pesok,alturaM);
        System.out.println("Tu IMC es:" + imc);

        System.out.println("Clasificacion:" + obtenerClasificacion(imc));
        scanner.close();
    }

    /**
     * @param se
     * @param mensaje
     * @return
     */
    public static double obtenerDouble(Scanner se, String mensaje){
        System.out.println(mensaje);
        return se.nextDouble();
    }

    /**
     *
     * @param pesoD
     * @param alturaD
     * @return double imc
     */

    public static double calcularImc(double pesoD, double alturaD) {
        return pesoD/(alturaD* alturaD);
    }

    /**
     *
     * @param imc previamente calculado
     * @return
     */
    public static String obtenerClasificacion(double imc) {
        if(imc<RANGO_BAJO)return "Bajo peso";
        else if(imc<RANGO_MEDIO)return "Peso medio";
        else if(imc<RANGO_ALTO)return "Sobrepeso";
        else return "Obecidad";
    }
}
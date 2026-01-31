import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int opcion = 0;
        // Contadores de cada conversion
        int celsiusF = 0, fahrenheitC = 0, kmMillas = 0, millasKm = 0;

        double valor, resultado;

        do {
            while (true) {
                System.out.println("MENU DE CONVERSIONES");
                System.out.println("1) °C a °F");
                System.out.println("2) °F a °C");
                System.out.println("3) Km a Millas");
                System.out.println("4) Millas a Km");
                System.out.println("5) Salir");
                System.out.print("Elige una opcion: ");

                if (leer.hasNextInt()) { // Verifica que sea un numero entero
                    opcion = leer.nextInt();
                    if (opcion >= 1 && opcion <= 5) {
                        break; // Opcion valida
                    }
                } else {
                    leer.next(); // Entrada incorrecta
                }

                System.out.println("Opcion invalida. Intenta de nuevo");
            }

            // Salir del programa
            if (opcion == 5) {
                System.out.println("Saliendo del programa");
                break;
            }

            // Pedir valor a convertir
            System.out.print("Ingresa un valor a convertir: ");
            while (!leer.hasNextDouble()) { // Valida que sea numero
                System.out.println(" Debes ingresar un numero");
                leer.next();
                System.out.print("Ingresa un valor a convertir: ");
            }
            valor = leer.nextDouble();

            // Realiza la conversion segun la opcion
            switch (opcion) {
                case 1:
                    resultado = (valor * 9 / 5) + 32;
                    System.out.println("Resultado: " + resultado + " °F");
                    celsiusF++;
                    break;

                case 2:
                    resultado = (valor - 32) * 5 / 9;
                    System.out.println("Resultado: " + resultado + " °C");
                    fahrenheitC++;
                    break;

                case 3:
                    resultado = valor * 0.621371;
                    System.out.println("Resultado: " + resultado + " millas");
                    kmMillas++;
                    break;

                case 4:
                    resultado = valor / 0.621371;
                    System.out.println("Resultado: " + resultado + " km");
                    millasKm++;
                    break;
            }

        } while (opcion != 5); // Repite hasta que elija salir

        // Total de conversiones realizadas
        int total = celsiusF + fahrenheitC + kmMillas + millasKm;

        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + celsiusF);
        System.out.println("°F a °C: " + fahrenheitC);
        System.out.println("Km a Millas: " + kmMillas);
        System.out.println("Millas a Km: " + millasKm);

        leer.close();
    }
}

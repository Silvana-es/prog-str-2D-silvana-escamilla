import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        Random random = new Random();

        // Genera numero del 1 al 100
        int secreto = random.nextInt(100) + 1;

        int intentos = 0;
        boolean gano = false;

        // Contadores de errores
        int erroresRango = 0;
        int erroresLetra = 0;

        System.out.println("JUEGO: ADIVINA EL NUMERO (1-100)");

        //Mientras tenga intentos y no haya ganado
        while (intentos < 7 && gano == false) {
            System.out.print("Intento " + (intentos + 1) + ". Ingresa un numero: ");

            // numero entero
            if (leer.hasNextInt()) {
                int numero = leer.nextInt();

                // dentro del rango 1-100
                if (numero >= 1 && numero <= 100) {

                    // Solo si es valido contamos el intento
                    intentos = intentos + 1;

                    if (numero == secreto) {
                        gano = true;
                        System.out.println("¡Ganaste!");
                    } else {
                        if (secreto > numero) {
                            System.out.println("El secreto es MAYOR.");
                        } else {
                            System.out.println("El secreto es MENOR.");
                        }
                    }

                } else {
                    // El numero no entra entre el 1 y 100
                    System.out.println("Error: Debe ser entre 1 y 100.");
                    erroresRango = erroresRango + 1;
                }

            } else {
                // Funcion para no escribir letras
                String letras = leer.next();
                System.out.println("Error: Eso no es un numero.");
                erroresLetra = erroresLetra + 1;
            }
        }

        if (gano == false) {
            System.out.println("Perdiste. El numero secreto era: " + secreto);
        }

        // Se muestran mis contadores
        System.out.println("Veces fuera de rango: " + erroresRango);
        System.out.println("Veces que no ingresó números: " + erroresLetra);
    }
}
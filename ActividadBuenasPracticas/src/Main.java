import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese un numero:");
        int numero = leer.nextInt();
        int resultado = sumaN(numero);
        System.out.println(mensaje() + ":" + resultado);
    }
    public static int sumaN(int numero) {
        int acumulador = 0;
        for (int i = 1; i <= numero; i++) {
            acumulador += i;
        }
        return acumulador;
    }
    public static String mensaje() {
        return "Este es tu resultado: ";
    }
}
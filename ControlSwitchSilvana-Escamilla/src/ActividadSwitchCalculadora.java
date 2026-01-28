import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("MENÚ CALCULADORA");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();

        double a, b, resultado;

        switch (opcion) {
            case 1:
                System.out.print("Ingresa el valor de a: ");
                a = scanner.nextDouble();
                System.out.print("Ingresa el valor de b: ");
                b = scanner.nextDouble();

                resultado = a + b;
                System.out.println("Operación: Suma");
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                System.out.print("Ingresa el valor de a: ");
                a = scanner.nextDouble();
                System.out.print("Ingresa el valor de b: ");
                b = scanner.nextDouble();

                resultado = a - b;
                System.out.println("Operación: Resta");
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                System.out.print("Ingresa el valor de a: ");
                a = scanner.nextDouble();
                System.out.print("Ingresa el valor de b: ");
                b = scanner.nextDouble();

                resultado = a * b;
                System.out.println("Operación: Multiplicación");
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                System.out.print("Ingresa el valor de a: ");
                a = scanner.nextDouble();
                System.out.print("Ingresa el valor de b: ");
                b = scanner.nextDouble();

                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    System.out.println("Operación: División");
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opción inválida");
        }

        scanner.close();
    }
}

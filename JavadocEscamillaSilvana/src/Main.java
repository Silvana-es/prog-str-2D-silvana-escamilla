import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        /**
         * Se utiliza el (do-while) para que el usuario seleccione la opcion q requiera o necesite
         */
        do {
            System.out.println(" MENU ");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular area de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa tu peso en kg: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingresa tu estatura en m): ");
                    double estatura = scanner.nextDouble();
                    double imc = calcularIMC(peso, estatura);
                    System.out.println("Tu IMC es: " + imc);
                    break;

                case 2:
                    System.out.print("Ingresa la base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingresa la altura: ");
                    double altura = scanner.nextDouble();

                    double areaRectangulo = calcularAreaRectangulo(base, altura);
                    System.out.println("Area del rectangulo: " + areaRectangulo);
                    break;

                case 3:
                    System.out.print("Ingresa grados Celsius: ");
                    double celsius = scanner.nextDouble();

                    double fahrenheit = convertirCelsiusAFahrenheit(celsius);
                    System.out.println("Grados Fahrenheit: " + fahrenheit);
                    break;

                case 4:
                    System.out.print("Ingresa el radio: ");
                    double radio = scanner.nextDouble();

                    double areaCirculo = calcularAreaCirculo(radio);
                    System.out.println("Área del círculo: " + areaCirculo);
                    break;

                case 5:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

            System.out.println();

        } while (choice != 5);

        scanner.close();
    }
    /**
     * Calcula el idice de masa corporal (IMC)
     * @param peso peso de la persona en kilogramos
     * @param estatura estatura de la persona en metros
     * @return valor del IMC calculado
     */
    public static double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }
    /**
     * Calcula el área de un rectangulo
     * @param base base del rectangulo
     * @param altura altura del rectángulo
     * @return área del rectángulo
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }
    /**
     * Convierte grados Celsius a Fahrenheit
     * @param celsius temperatura en grados Celsius
     * @return temperatura convertida a Fahrenheit
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }
    /**
     * Calcula el área de un círculo
     * @param radio radio del círculo
     * @return área del círculo
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}

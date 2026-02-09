import java.util.Scanner;

public class InputValidator {
    public String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.println(msg);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El texto no puede estar vacio");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double value;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                if (value >= min && value <= max) {
                    sc.nextLine();
                    return value;
                }
                System.out.println("Debe estar entre " + min + " y " + max);
            } else {
                System.out.println("No es un numero valido");
                sc.next();
            }
        }
    }

    public int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int value;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                if (value >= min && value <= max) {
                    sc.nextLine();
                    return value;
                }
                System.out.println("Debe estar entre " + min + " y " + max);
            } else {
                System.out.println("No es un entero valido");
                sc.next();
            }
        }
    }

    public boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                boolean value = sc.nextBoolean();
                sc.nextLine();
                return value;
            } else {
                System.out.println("Solo se acepta true o false");
                sc.next();
            }
        }
    }
}

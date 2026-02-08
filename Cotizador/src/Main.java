import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {

        Scanner sc = new Scanner(System.in);
        InputDataValidator inputDataValidator = new InputDataValidator();
        ShippingCalculator shippingCalculator = new ShippingCalculator();

        double pesoKg = inputDataValidator.leerDoubleEnRango(sc, "Ingresa el peso en KG: ", 0.1, 50);

        int distanciaKm = inputDataValidator.leerIntEnRango(sc, "Ingresa la distancia en KM: ", 1, 2000);

        int tipoServicio = inputDataValidator.leerIntEnRango(sc, "Ingresa el tipo de servicio 1)Estandar 2)Express", 1, 2);

        boolean esZonaRemota = inputDataValidator.leerBoolean(sc, "Es zona remota? (true/false)");
        double subtotal = shippingCalculator.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);

        double iva = shippingCalculator.calcularIVA(subtotal);

        double total = shippingCalculator.calcularTotal(subtotal, iva);


        // OUTPUT
        imprimirTicket(pesoKg, distanciaKm, tipoServicio, esZonaRemota, subtotal, iva, total);
    }


    public static void imprimirTicket(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota, double subtotal, double iva, double total) {

        System.out.println("Servicio: " + tipoServicio);
        System.out.println("Peso: " + pesoKg);
        System.out.println("Distancia: " + distanciaKm);
        System.out.println("Zona Remota: " + esZonaRemota);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA: $" + iva);
        System.out.println("Total: $" + total);
    }
}

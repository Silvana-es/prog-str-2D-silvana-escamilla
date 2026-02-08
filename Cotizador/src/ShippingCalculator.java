public class ShippingCalculator {
   /* public double pesoKg;
    public int distanciaKm;
    public int tipoServicio;
    public boolean esZonaRemota;*/
    private final double IVA=0.16;
    private final double PRECIO_ESTANDAR=50;
    private final double PRECIO_EXPRESS=90;


    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota ){
        double subtotal=0;
        // Base por servicio
        if (tipoServicio == 1) {
            subtotal += PRECIO_ESTANDAR;
        } else {
            subtotal += PRECIO_EXPRESS;
        }

        // Costo por peso
        subtotal += 12 * pesoKg;

        // Costo por distancia
        if (distanciaKm <= 50) {
            subtotal += 20;
        } else if (distanciaKm <= 200) {
            subtotal += 60;
        } else {
            subtotal += 120;
        }

        // Zona remota
        if (esZonaRemota) {
            subtotal += subtotal * 0.10;
        }

        return subtotal;
    }

    public double calcularIVA(double subtotal){

        return subtotal*IVA;
    }
    public double calcularTotal(double subtotal,double  iva){

        return subtotal + iva;
    }

}

package propoo;
public class Dron extends Aereo {
    public Dron() {
        super("Dron Delivery", 40.0, 2.0, 1200.0);
    }
    @Override
    public double calcularCosto(double d, double p) {
        return (d * p * costo_Km) + 15000.0;
    }
}
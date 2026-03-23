package propoo;
public class Moto extends Terrestre {
    public Moto() {
        super("Moto Speed", 75.0, 20.0, 250.0);
    }
    @Override
    public double calcularCosto(double d, double p) {
        return (d * p * costo_Km) + 8000.0;
    }
}
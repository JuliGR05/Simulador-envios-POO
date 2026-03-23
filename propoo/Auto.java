package propoo;
public class Auto extends Terrestre {
    public Auto() {
        super("Automóvil Logístico", 90.0, 100.0, 450.0);
    }
    @Override
    public double calcularCosto(double d, double p) {
        return (d * p * costo_Km) + 25000.0;
    }
}
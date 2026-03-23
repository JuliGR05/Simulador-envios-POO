package propoo;
public class Bicicleta extends Terrestre {
    public Bicicleta() {
        super("Bicicleta Mensajería", 15.0, 5.0, 150.0);
    }
    @Override
    public double calcularCosto(double d, double p) {
        return (d * p * costo_Km) + 3500.0;
    }
}
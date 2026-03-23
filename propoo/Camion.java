package propoo;
public class Camion extends Terrestre {
    public Camion() {
        super("Camión de Carga Turbo", 60.0, 2000.0, 50.0);
    }
    @Override
    public double calcularCosto(double d, double p) {
        return (d * p * costo_Km) + 150000.0;
    }
}
package propoo;
public class Avion extends Aereo {
    public Avion() {
        super("Avión de Carga Nacional", 850.0, 300.0, 350.0);
    }
    @Override
    public double calcularCosto(double d, double p) {
        return (d * p * costo_Km) + 450000.0;
    }
}
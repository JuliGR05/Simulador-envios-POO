package propoo;
public class Camion extends Terrestre {
    public Camion() { super("Camión de carga", 55.0, 8000.0, 1.5); }
    @Override public boolean validarDistancia(double d) { return d >= 30; }
    @Override public String getMensajeErrorDistancia() { return "Mínimo 30km para rutas intermunicipales."; }
    @Override public double calcularCosto(double d, double p) { return 45000.0 + (d * p * getCostoFactor()); }
}
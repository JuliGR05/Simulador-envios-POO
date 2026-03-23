package propoo;
public class Camion extends Terrestre {
    public Camion() { super("Camión de carga", 55.0, 8000.0, 0.5); }
    @Override public boolean validarDistancia(double d) { return d >= 0; }
    @Override public String getMensajeErrorDistancia() { return ""; }
    @Override public double calcularCosto(double d, double p) { return 45000.0 + (d * p * getCostoFactor()); }
}
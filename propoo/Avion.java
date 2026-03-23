package propoo;
public class Avion extends Aereo {
    public Avion() { super("Avion de carga", 820.0, 2000.0, 8.0); }
    @Override public boolean validarDistancia(double d) { return d >= 400; }
    @Override public String getMensajeErrorDistancia() { return "Distancia mínima aérea: 400km."; }
    @Override public double calcularCosto(double d, double p) { return 85000.0 + (d * p * getCostoFactor()); }
}
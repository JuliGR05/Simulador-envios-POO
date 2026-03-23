package propoo;
public class Dron extends Aereo {
    public Dron() { super("Dron de domicilios", 40.0, 2.0, 25.0); }
    @Override public boolean validarDistancia(double d) { return d <= 40; }
    @Override public String getMensajeErrorDistancia() { return "Excede rango de vuelo (máx 40km)."; }
    @Override public double calcularCosto(double d, double p) { return 10000.0 + (d * p * getCostoFactor()); }
}
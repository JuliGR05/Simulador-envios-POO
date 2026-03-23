package propoo;
public class Bicicleta extends Terrestre {
    public Bicicleta() { super("Bicicleta", 15.0, 5.0, 2.0); }
    @Override public boolean validarDistancia(double d) { return d <= 40; }
    @Override public String getMensajeErrorDistancia() { return "Excede rango urbano (máx 40km)."; }
    @Override public double calcularCosto(double d, double p) { return 3500.0 + (d * p * getCostoFactor()); }
}
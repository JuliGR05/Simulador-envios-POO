package propoo;
public class Auto extends Terrestre {
    public Auto() { super("Carro", 85.0, 350.0, 10.0); }
    @Override public boolean validarDistancia(double d) { return true; }
    @Override public String getMensajeErrorDistancia() { return ""; }
    @Override public double calcularCosto(double d, double p) { return 15000.0 + (d * p * getCostoFactor()); }
}
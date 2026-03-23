package propoo;
public class Moto extends Terrestre {
    public Moto() { super("Moto", 65.0, 25.0, 5.0); }
    @Override public boolean validarDistancia(double d) { return true; } 
    @Override public String getMensajeErrorDistancia() { return ""; }
    @Override public double calcularCosto(double d, double p) { return 5500.0 + (d * p * getCostoFactor()); }
}
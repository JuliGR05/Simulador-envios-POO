package propoo;

public abstract class Vehiculo {
    private String nombre;
    private double velocidad;
    private double capacidadMax;
    private double costoFactor;

    public Vehiculo(String nombre, double velocidad, double capacidadMax, double costoFactor) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.capacidadMax = capacidadMax;
        this.costoFactor = costoFactor;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getVelocidad() { return velocidad; }
    public double getCapacidadMax() { return capacidadMax; }
    public double getCostoFactor() { return costoFactor; }

    public boolean validarCarga(double carga) {
        return carga <= capacidadMax;
    }

    public double calcularTiempo(double distancia) {
        return distancia / velocidad;
    }

    public abstract boolean validarDistancia(double distancia);
    public abstract String getMensajeErrorDistancia();
    public abstract double calcularCosto(double distancia, double peso);
}
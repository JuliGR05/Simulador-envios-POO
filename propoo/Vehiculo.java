package propoo;
public abstract class Vehiculo {
    public String nombre;
    public double velocidad;
    public double capacidad_max;
    public double costo_Km; // Este ahora actúa como el "Factor" por kg/km

    public Vehiculo(String nombre, double velocidad, double capacidad_max, double costo_Km) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.capacidad_max = capacidad_max;
        this.costo_Km = costo_Km;
    }

    public boolean validarCarga(double carga) {
        return carga <= capacidad_max;
    }

    public double calcularTiempo(double distancia) {
        return distancia / velocidad;
    }

    public abstract double calcularCosto(double distancia, double peso);
}
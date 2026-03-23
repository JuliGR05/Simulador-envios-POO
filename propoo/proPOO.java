package propoo;
import java.util.Scanner;

public class proPOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] departamentos = {
            "Cundinamarca", "Meta", "Boyacá", "Tolima", "Caldas", "Quindío", 
            "Risaralda", "Huila", "Antioquia", "Santander", "Valle del Cauca", 
            "Casanare", "Cauca", "Norte de Santander", "Arauca", "Córdoba", 
            "Nariño", "Caquetá", "Putumayo", "Bolívar", "Cesar", "Sucre", 
            "Atlántico", "Magdalena", "La Guajira", "Chocó", "Guainía", 
            "Vaupés", "Guaviare", "Vichada", "Amazonas", "San Andrés", "Bogotá D.C."
        };

        double[] distDeptos = {
            50, 73, 135, 126, 166, 177, 180, 228, 245, 298, 301, 320, 370, 
            404, 430, 499, 517, 390, 450, 659, 654, 620, 707, 733, 820, 
            370, 820, 750, 430, 700, 1160, 1050, 0
        };
        String[] localidades = {
            "Teusaquillo", "Barrios Unidos", "Santa Fe", "Los Mártires", "Usaquén", 
            "Engativá", "La Candelaria", "Suba", "Antonio Nariño", "Puente Aranda", 
            "Fontibón", "Kennedy", "Rafael Uribe Uribe", "Tunjuelito", "San Cristóbal", 
            "Bosa", "Usme", "Ciudad Bolívar", "Sumapaz"
        };

        double[] distLocalidades = {
            2.5, 3.0, 3.2, 4.5, 5.5, 6.0, 6.2, 7.5, 7.8, 7.9, 
            9.5, 10.5, 11.0, 11.5, 12.0, 14.0, 16.5, 16.8, 55.0
        };

        System.out.println("=== SOFTWARE DE LOGÍSTICA NACIONAL (ORIGEN: BOGOTÁ) ===");
        System.out.println("\nSeleccione el Departamento de destino:");
        for (int i = 0; i < departamentos.length; i++) {
            System.out.printf("%2d. %s\n", (i + 1), departamentos[i]);
        }
        System.out.print("Opción: ");
        int opDepto = scanner.nextInt();
        
        String nombreDestino = departamentos[opDepto - 1];
        double distanciaFinal = distDeptos[opDepto - 1];

        if (nombreDestino.equals("Bogotá D.C.")) {
            System.out.println("\n--- SELECCIÓN DE LOCALIDAD EN BOGOTÁ ---");
            for (int j = 0; j < localidades.length; j++) {
                System.out.printf("%2d. %s\n", (j + 1), localidades[j]);
            }
            System.out.print("Opción: ");
            int opLoc = scanner.nextInt();
            nombreDestino = localidades[opLoc - 1];
            distanciaFinal = distLocalidades[opLoc - 1];
        }
        System.out.print("\nIngrese el peso de la mercancía (kg): ");
        double pesoCarga = scanner.nextDouble();

        if (pesoCarga <= 0) {
            System.out.println("Error: El peso debe ser mayor a 0.");
            return;
        }
        Vehiculo[] flota = { 
            new Dron(), new Bicicleta(), new Moto(), 
            new Auto(), new Avion(), new Camion() 
        };
        System.out.println("\n" + "=".repeat(55));
        System.out.println("REPORTE DE COTIZACIÓN - DESTINO: " + nombreDestino.toUpperCase());
        System.out.println("Distancia: " + distanciaFinal + " km | Peso: " + pesoCarga + " kg");
        System.out.println("=".repeat(55));

        for (Vehiculo v : flota) {
            System.out.println("TRANSPORTE: " + v.nombre);

            boolean distApta = true;
            String msgError = "";
            if (v instanceof Avion && distanciaFinal < 400) {
                distApta = false;
                msgError = "Distancia mínima aérea: 400km.";
            } else if (v instanceof Camion && distanciaFinal < 30) {
                distApta = false;
                msgError = "Uso exclusivo para rutas de larga distancia.";
            } else if ((v instanceof Bicicleta || v instanceof Dron) && distanciaFinal > 40) {
                distApta = false;
                msgError = "Excede el rango de autonomía urbana.";
            }
            if (!v.validarCarga(pesoCarga)) {
                System.out.println(" > ESTADO: RECHAZADO (Capacidad máx: " + v.capacidad_max + " kg)");
            } else if (!distApta) {
                System.out.println(" > ESTADO: RECHAZADO (" + msgError + ")");
            } else {
                double costoTotal = v.calcularCosto(distanciaFinal, pesoCarga);
                double tiempoEst = v.calcularTiempo(distanciaFinal);

                System.out.println(" > ESTADO: DISPONIBLE");
                System.out.printf(" > COSTO DE ENVÍO: $%,.0f COP\n", costoTotal);
                System.out.printf(" > TIEMPO ESTIMADO: %.2f horas\n", tiempoEst);
            }
            System.out.println("-".repeat(55));
        }
        scanner.close();
    }
}
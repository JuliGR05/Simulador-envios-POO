package propoo;
import java.util.Scanner;

public class proPOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] departamentos = {
            "Cundinamarca", "Meta", "Boyaca", "Tolima", "Caldas", "Quindio", 
            "Risaralda", "Huila", "Antioquia", "Santander", "Valle del Cauca", 
            "Casanare", "Cauca", "Norte de Santander", "Arauca", "Cordoba", 
            "Narino", "Caqueta", "Putumayo", "Bolivar", "Cesar", "Sucre", 
            "Atlantico", "Magdalena", "La Guajira", "Choco", "Guainia", 
            "Vaupes", "Guaviare", "Vichada", "Amazonas", "San Andres", "Bogota D.C."
        };

        double[] distDeptos = {
            50, 73, 135, 126, 166, 177, 180, 228, 245, 298, 301, 320, 370, 
            404, 430, 499, 517, 390, 450, 659, 654, 620, 707, 733, 820, 
            370, 820, 750, 430, 700, 1160, 1050, 0
        };

        String[] localidades = {
            "Teusaquillo", "Barrios Unidos", "Santa Fe", "Los Martires", "Usaquen", 
            "Engativa", "La Candelaria", "Suba", "Antonio Narino", "Puente Aranda", 
            "Fontibon", "Kennedy", "Rafael Uribe Uribe", "Tunjuelito", "San Cristobal", 
            "Bosa", "Usme", "Ciudad Bolivar", "Sumapaz"
        };

        double[] distLocalidades = {
            2.5, 3.0, 3.2, 4.5, 5.5, 6.0, 6.2, 7.5, 7.8, 7.9, 
            9.5, 10.5, 11.0, 11.5, 12.0, 14.0, 16.5, 16.8, 55.0
        };

        System.out.println("=== SOFTWARE DE LOGISTICA (ORIGEN: BOGOTA) ===");
        System.out.println("Seleccione el Departamento de destino:");
        for (int i = 0; i < departamentos.length; i++) {
            System.out.println((i + 1) + ". " + departamentos[i]);
        }
        
        // Para el departamento
        int opDepto = 0;
            boolean valido = false;

            while (!valido) {
                System.out.print("Opcion: ");
            
                try {
                    opDepto = scanner.nextInt();

                    if (opDepto < 1 || opDepto > departamentos.length) {
                        System.out.println("Error: Seleccion no valida.");
                    } else {
                        valido = true;
                }

                } catch (Exception e) {
                    System.out.println("Error: debes ingresar un número válido.");
                    scanner.next();
                }
            }

            String nombreDestino = departamentos[opDepto - 1];
            double distanciaFinal = distDeptos[opDepto - 1];

        // Para la localidad
        if (nombreDestino.equals("Bogota D.C.")) {
            System.out.println("--- SELECCION DE LOCALIDAD EN BOGOTA ---");
            for (int j = 0; j < localidades.length; j++) {
                System.out.println((j + 1) + ". " + localidades[j]);
            }

            int opLoc = 0;
            boolean locValida = false;

            while (!locValida) {
                System.out.print("Opcion Localidad: ");
                
                try {
                    opLoc = scanner.nextInt();

                    if (opLoc >= 1 && opLoc <= localidades.length) {
                        nombreDestino = localidades[opLoc - 1];
                        distanciaFinal = distLocalidades[opLoc - 1];
                        locValida = true;
                    } else {
                        System.out.println("Localidad no valida, intenta de nuevo.");
                    }

                } catch (Exception e) {
                    System.out.println("Error: debes ingresar un número válido.");
                    scanner.next();
                }
            }
        }

        //Para el peso
        double pesoCarga = 0;
        boolean pesoValido = false;

        while (!pesoValido) {
            System.out.print("\nIngrese el peso de la carga (kg): ");
            
            try {
                pesoCarga = scanner.nextDouble();

                if (pesoCarga > 0) {
                    pesoValido = true;
                } else {
                    System.out.println("Error: el peso debe ser positivo.");
                }

            } catch (Exception e) {
                System.out.println("Error: debes ingresar un número válido.");
                scanner.next();
            }
        }

        Vehiculo[] flota = { 
            new Dron(), new Bicicleta(), new Moto(), 
            new Auto(), new Avion(), new Camion() 
        };

        System.out.println("============================================================");
        System.out.println("REPORTE PARA: " + nombreDestino.toUpperCase());
        System.out.println("DISTANCIA: " + distanciaFinal + " km | PESO: " + pesoCarga + " kg");
        System.out.println("============================================================");

        for (Vehiculo v : flota) {
            System.out.println("VEHICULO: " + v.getNombre());

            if (!v.validarCarga(pesoCarga)) {
                System.out.println(" > ESTADO: RECHAZADO (Capacidad max: " + v.getCapacidadMax() + " kg)");
            } else if (!v.validarDistancia(distanciaFinal)) {
                System.out.println(" > ESTADO: RECHAZADO (" + v.getMensajeErrorDistancia() + ")");
            } else {
                double costo= v.calcularCosto(distanciaFinal, pesoCarga);
                double tiempo = v.calcularTiempo(distanciaFinal);
                
                long costoFinal = (long) (costo + 0.5);
                double tiempoFinal = ((long) (tiempo * 100 + 0.5)) / 100.0;

                System.out.println(" > ESTADO: DISPONIBLE");
                System.out.println(" > COSTO DE ENVIO: $" + costoFinal + " COP");
                System.out.println(" > TIEMPO ESTIMADO: " + tiempoFinal + " horas");
            }
            System.out.println("------------------------------------------------------------");
        }

        scanner.close();
    }
}
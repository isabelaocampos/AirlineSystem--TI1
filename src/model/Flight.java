package model;
import java.util.*;

public class Flight<K, V extends Passenger> {
    private String numeroVuelo;
    private String fecha;
    private String horaSalida;
    private Map<K, V> passengersForDestiny;
    
    public Flight(String numeroVuelo, String fecha, String horaSalida) {
        this.numeroVuelo = numeroVuelo;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.passengersForDestiny = new HashMap<>();
    }
    
    // Métodos get y set para los atributos
    
    public String getNumeroVuelo() {
        return numeroVuelo;
    }
    
    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getHoraSalida() {
        return horaSalida;
    }
    
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    public Map<K, V> getpassengersForDestiny() {
        return passengersForDestiny;
    }
    
    public void setpassengersForDestiny(Map<K, V> passengersForDestiny) {
        this.passengersForDestiny = passengersForDestiny;
    }
    
    // Métodos para agregar y ordenar los pasajeros
    
    public void agregarPasajero(V passengers, K destino) {
        passengersForDestiny.put(destino, passengers);
    }
    
    public void ordenarPasajerosPorLlegada() {
        List<V> pasajeros = new ArrayList<>(passengersForDestiny.values());
        Collections.sort(pasajeros, new Comparator<V>() {
            public int compare(V p1, V p2) {
                // Ordenar por el tiempo de llegada del passengers
                return p1.getArrivalTime().compareTo(p2.getArrivalTime());
            }
        });
        passengersForDestiny.clear();
        for (V passengers : pasajeros) {
            passengersForDestiny.put((K) passengers.getDestino(), passengers);
        }
    }
    
    public void ordenarPasajerosPorPrimeraClase() {
        List<V> pasajeros = new ArrayList<>(passengersForDestiny.values());
        Collections.sort(pasajeros, new Comparator<V>() {
            public int compare(V p1, V p2) {
                // Ordenar por si el passengers es de primera clase o no
                return Boolean.compare(p2.isPrimeraClase(), p1.isPrimeraClase());
            }
        });
        passengersForDestiny.clear();
        for (V passengers : pasajeros) {
            passengersForDestiny.put((K) passengers.getDestino(), passengers);
        }
    }
    
    public void imprimirpassengersForDestiny() {
        // Crear la tabla hash
        Map<String, List<Passenger>> passengersForDestiny = new HashMap<>();
    
        // Agregar los pasajeros a la tabla hash según su destino
        for (Passenger passengers : passengers) {
            String destino = passengers.getArrivalTime().getDestino();
            List<Passenger> pasajerosDestino = passengersForDestiny.getOrDefault(destino, new ArrayList<>());
            pasajerosDestino.add(passengers);
            passengersForDestiny.put(destino, pasajerosDestino);
        }
    
        // Imprimir los pasajeros por destino
        for (String destino : passengersForDestiny.keySet()) {
            System.out.println("Pasajeros con destino " + destino + ":");
            for (Passenger passengers : passengersForDestiny.get(destino)) {
                System.out.println("- " + passengers.getNombre() + ", número de pasaporte: " + passengers.getNumeroPasaporte());
            }
            System.out.println();
        }
    }
}    
    




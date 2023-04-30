package model;
import java.util.*;

public class Flight {
    private String numeroVuelo;
    private String fecha;
    private String horaSalida;
    private HashTable<String, List<Passenger>> pasajerosPorDestino;

    public Flight(String numeroVuelo, String fecha, String horaSalida) {
        this.numeroVuelo = numeroVuelo;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.pasajerosPorDestino = new HashTable<>(100);
    }

    // ...

    public void agregarPasajero(Passenger pasajero) {
        String destino = pasajero.getDestino();
        List<Passenger> pasajeros = pasajerosPorDestino.get(destino);
        if (pasajeros == null) {
            pasajeros = new ArrayList<>();
            pasajerosPorDestino.put(destino, pasajeros);
        }
        pasajeros.add(pasajero);
    }

    public void imprimirPasajerosPorDestino() {
        Hashtable<String, List<Passenger>> pasajerosPorDestino = new Hashtable<>();

        // Agrupar los pasajeros por destino en la tabla hash
        for (Passenger pasajero : pasajeros){
            String destino = pasajero.getDestino();
            List<Passenger> pasajerosEnDestino = pasajerosPorDestino.getOrDefault(destino, new ArrayList<>());
            pasajerosEnDestino.add(pasajero);
            pasajerosPorDestino.put(destino, pasajerosEnDestino);
        }

        // Imprimir la información de los pasajeros por destino
        System.out.println("Pasajeros por destino:");
        for (String destino : pasajerosPorDestino.keySet()) {
            System.out.println(destino + ":");
            List<Passenger> pasajerosEnDestino = pasajerosPorDestino.get(destino);
            for (Passenger pasajero : pasajerosEnDestino) {
                System.out.println("  " + pasajero.getNombre() + " - Asiento: " + pasajero.getNumChair());
            }
        }
    }

}

    




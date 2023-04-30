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
        System.out.println("Pasajeros por destino:");
        for (String destino : pasajerosPorDestino.keys()) {
            System.out.println(destino);
            for (Passenger pasajero : pasajerosPorDestino.get(destino)) {
                System.out.println("- " + pasajero.getNombre());
            }
        }
    }
}

    




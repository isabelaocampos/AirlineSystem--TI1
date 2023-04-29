package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight<T> {
    private String numero;
    private Map<String, Passenger<T>> passengers;
    
    public Flight(String numero) {
        this.numero = numero;
        passengers = new HashMap<>();
    }
    
    public void cargarPasajeros(List<Passenger<T>> passengers) {
        for (Passenger<T> pasajero : passengers) {
            this.passengers.put(pasajero.getNombre(), pasajero);
        }
    }
    
    public Map<String, Passenger<T>> getPasajeros() {
        return passengers;
    }
}



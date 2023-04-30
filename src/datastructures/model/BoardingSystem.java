package datastructures.model;

import java.util.PriorityQueue;
import java.util.Queue;

public class BoardingSystem<T> {
    private Queue<Passenger<T>> colaPasajeros;
    
    public BoardingSystem() {
        colaPasajeros = new PriorityQueue<>();
    }
    
    public void agregarPasajero(Passenger<T> pasajero) {
        colaPasajeros.add(pasajero);
    }
    
    public Passenger<T> siguientePasajero() {
        return colaPasajeros.poll();
    }
}


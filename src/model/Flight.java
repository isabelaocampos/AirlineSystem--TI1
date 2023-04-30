package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class Flight<T extends Passenger>{
    private String numeroFlight;
    private String fecha;
    private String horaSalida;
    private List<T> Passengers;
    private Queue<T> colaEspera;
    private Map<String, BoardingSystem<T>> salasAbordaje;
    private PriorityQueue<T> passengersPrioritarios;
    
    public Flight(String numeroFlight, String fecha, String horaSalida) {
        this.numeroFlight = numeroFlight;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.Passengers = new ArrayList<>();
        this.colaEspera = new LinkedList<>();
        this.salasAbordaje = new HashMap<>();
        this.passengersPrioritarios = new PriorityQueue<>(new Comparator<T>() {
            public int compare(T p1, T p2) {
                // Ordenar por la prioridad del Passenger
                return p2.getPriorid ad() - p1.getPrioridad();
            }
        });
    }
    
    // Métodos get y set para los atributos
    
    public String getNumeroFlight() {
        return numeroFlight;
    }
    
    public void setNumeroFlight(String numeroFlight) {
        this.numeroFlight = numeroFlight;
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
    
    public List<T> getPassengers() {
        return Passengers;
    }
    
    public void setPassengers(List<T> Passengers) {
        this.Passengers = Passengers;
    }
    
    // Métodos para agregar y ordenar los Passengers
    
    public void agregarPassenger(T Passenger) {
        Passengers.add(Passenger);
    }
    
    public void agregarPassengerColaEspera(T Passenger) {
        colaEspera.add(Passenger);
    }
    
    public T obtenerSiguientePassengerColaEspera() {
        return colaEspera.poll();
    }
    
    public void agregarSalaAbordaje(String nombreSala, BoardingSystem<T> salaAbordaje) {
        salasAbordaje.put(nombreSala, salaAbordaje);
    }
    
    public BoardingSystem<T> obtenerSalaAbordaje(String nombreSala) {
        return salasAbordaje.get(nombreSala);
    }
    
    public void agregarPassengerPrioritario(T Passenger) {
        passengersPrioritarios.add(Passenger);
    }
    
    public T obtenerSiguientePassengerPrioritario() {
        return passengersPrioritarios.poll();
    }
    
    public void orderPassengerForSeat() {
        Collections.sort(Passengers, new Comparator<T>() {
            public int compare(T p1, T p2) {
                // Ordenar por el tiempo de llegada del Passenger
                return p1.getSeatNumber().compareTo(p2.getSeatNumber());
            }
        });
    }
}    




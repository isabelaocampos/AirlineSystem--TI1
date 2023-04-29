package model;

import java.sql.Date;

public class Passenger<T> {
    private String nombre;
    private String numeroPasaporte;
    private String seatNumber;
    private Date timeArrive;
    
    public Passenger(String nombre, String numeroPasaporte, String seatNumber, Date timeArrive) {
        this.nombre = nombre;
        this.numeroPasaporte = numeroPasaporte;
        this.seatNumber = seatNumber;
        this.timeArrive = timeArrive;
    }
    
    // Métodos get y set para los atributos
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }
    
    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }
    
    public String getSeatNumber() {
        return seatNumber;
    }
    
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}

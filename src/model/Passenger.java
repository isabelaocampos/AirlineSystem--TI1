package model;

import java.sql.Date;

public class Passenger<T> {
    private String nombre;
    private String numeroPasaporte;
    private String informacionVuelo;
    
    public Passenger(String nombre, String numeroPasaporte, String informacionVuelo) {
        this.nombre = nombre;
        this.numeroPasaporte = numeroPasaporte;
        this.informacionVuelo = informacionVuelo;
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
    
    public String getInformacionVuelo() {
        return informacionVuelo;
    }
    
    public void setInformacionVuelo(String informacionVuelo) {
        this.informacionVuelo = informacionVuelo;
    }
}

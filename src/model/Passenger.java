package model;

import java.sql.Date;

public class Passenger<T> {
    private String nombre;
    private String numeroPasaporte;
    private int numSilla;
    private String letraSilla;
    private int timeArrive;
    private Boolean specialCase;
    
    public Passenger(String nombre, String numeroPasaporte, int numSilla, String letraSilla, int timeArrive, Boolean specialCase) {
        this.nombre = nombre;
        this.numeroPasaporte = numeroPasaporte;
        this.numSilla = numSilla;
        this.letraSilla = letraSilla;
        this.timeArrive = timeArrive;
        this.specialCase = specialCase;
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

    public int getNumSilla() {
        return numSilla;
    }
    
    public void setNumSIlla(int numSilla) {
        this.numSilla = numSilla;
    }
    
    public String getletraSilla() {
        return letraSilla;
    }
    
    public void setletraSilla(String letraSilla) {
        this.letraSilla = letraSilla;
    }

    public int getArrivalTime() {
        return timeArrive;
    }
    
    public void setArrivalTime(int timeArrive) {
        this.timeArrive = timeArrive;
    }
    
    public Boolean getSpecialCase() {
        return specialCase;
    }
    
    public void setSpecialCase(Boolean specialCase) {
        this.specialCase = specialCase;
    }
}

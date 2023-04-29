package model;

import java.sql.Date;
import java.util.Comparator;

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


    public class ComparadorPorHora<T extends Comparable<T>> implements Comparator<Passenger<T>> {
        @Override
        public int compare(Passenger<T> p1, Passenger<T> p2) {
            return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
        }
    }

    public class ComparadorPorSilla<T extends Comparable<T>> implements Comparator<Passenger<T>> {
        @Override
        public int compare(Passenger<T> p1, Passenger<T> p2) {
            int resultadoPorNumSilla = Integer.compare(p1.getNumSilla(), p2.getNumSilla());
            if (resultadoPorNumSilla != 0) {
                return resultadoPorNumSilla;
            } else {
                return p1.getletraSilla().compareTo(p2.getletraSilla());
            }
        }
    
    
}
}

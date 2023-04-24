package model;

import java.sql.Date;

public class Passenger{
    private String name;
    private int seatAssigned;
    private int miles;
    private boolean needsEspecialAttention;
    private String passportId;
    private Date registeredHour;
    private int fila;



    public Passenger(String name, int seatAssigned, int miles, boolean needsEspecialAttention, String passportId, Date registeredHour, int fila){
        this.name = name;
        this.seatAssigned = seatAssigned;
        this.miles = miles;
        this.needsEspecialAttention = needsEspecialAttention;
        this.passportId = passportId;
        this.registeredHour = registeredHour;
        this.fila = fila;

    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSeatAssigned(){
        return seatAssigned;
    }

    public void setSeatAssigned(int seatAssigned){
        this.seatAssigned = seatAssigned;

    }

    public int getMiles(){
        return miles;
    }

    public void setMiles(int miles){
        this.miles = miles;
    }

    public boolean getNeedsEspecialAttention(){
        return needsEspecialAttention;
    }

    public void setNeedsEspecialAttention(boolean needsEspecialAttention){
        this.needsEspecialAttention = needsEspecialAttention;
    }

    public String getPassportId(){
        return passportId;
    }

    public void setPassportId(String passportId){
        this.passportId = passportId;
    }

    public Date getRegisteredHour(){
        return registeredHour;
    }

    public void setRegisteredHour(Date registeredHour){
        this.registeredHour = registeredHour;
    }

    public int getFila(){
        return fila;
    }

    public void setFila(int fila){
        this.fila = fila;
    }



}
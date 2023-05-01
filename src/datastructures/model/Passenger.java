package datastructures.model;

import java.time.LocalTime;

public class Passenger implements Comparable<Passenger> {
    private String nombre;
    private int agePassenger;
    private int numPassport;
    private int numChair;
    private String chairLetter;
    private LocalTime timeArrive;
    private int millesPassenger;
    private Boolean specialCase;

    private String destination;
    
    public Passenger(String nombre, int numPassport, int agePassenger, int millesPassenger, int numChair, String chairLetter, Boolean specialCase) {
        this.nombre = nombre;
        this.agePassenger = agePassenger;
        this.millesPassenger = millesPassenger;
        this.numPassport = numPassport;
        this.numChair = numChair;
        this.chairLetter = chairLetter;
        this.specialCase = specialCase;
    }
    
    // Métodos get y set para los atributos
    
    public String getNombre() {

        return nombre;
    }
    
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
    
    public int getNumeroPasaporte() {

        return numPassport;
    }
    
    public void setNumPassport(int numPassport) {

        this.numPassport = numPassport;
    }

    public int getNumChair() {

        return numChair;
    }
    
    public void setNumChair(int numSilla) {

        this.numChair = numSilla;
    }
    
    public String getChairLetter() {

        return chairLetter;
    }
    
    public void setChairLetter(String chairLetter) {

        this.chairLetter = chairLetter;
    }

    public LocalTime getArrivalTime() {
        return timeArrive;
    }
    
    public void setArrivalTime(LocalTime timeArrive) {

        this.timeArrive = timeArrive;
    }
    
    public Boolean getSpecialCase() {

        return specialCase;
    }
    
    public void setMiles(int millesPassenger) {

        this.millesPassenger = millesPassenger;
    }
    public int getMiles() {

        return millesPassenger;
    }
    public int getAgePassenger() {

        return agePassenger;
    }

    public void setAgePassenger(int agePassenger) {

        this.agePassenger = agePassenger;
    }

    public void setSpecialCase(Boolean specialCase) {

        this.specialCase = specialCase;
    }
    private int getSeatLetter(String chairLetter) {
        switch (chairLetter) {
            case "C": case "D": return 1;
            case "B": case "E": return 2;
            case "A": case "F": return 3;
            default: throw new IllegalArgumentException("Invalid seat letter:" + chairLetter);
        }
    }



    @Override
    public int compareTo(Passenger another) {
        int milesPass = Integer.compare(this.millesPassenger,another.getMiles());

        if(milesPass !=0){
            return milesPass;
        }else{
            return Integer.compare(this.agePassenger,another.getAgePassenger());
        }
    }

    public int compareSeats(Passenger another){
        int compareTheSeats = Integer.compare(this.numChair, another.getNumChair());
        if(compareTheSeats != 0){
            return compareTheSeats;
        }

        int chairLetter1 = getSeatLetter(this.chairLetter);
        int chairLetter2 = getSeatLetter(another.getChairLetter());
        int compareChair = Integer.compare(chairLetter1,chairLetter2);
        if(compareChair != 0){
            return compareChair;
        }

        return this.timeArrive.compareTo(another.getArrivalTime());


    }

    @Override
    public String toString() {
        return "Passenger is :" + nombre + ".";
    }





}

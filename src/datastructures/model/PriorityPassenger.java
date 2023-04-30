package datastructures.model;

public class PriorityPassenger implements Comparable<PriorityPassenger>{

    private Passenger passenger;

    public PriorityPassenger(Passenger passenger){
        this.passenger = passenger;
    }

    @Override
    public int compareTo(PriorityPassenger o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
}

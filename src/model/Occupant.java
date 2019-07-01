package model;

public class Occupant {
    
    private int idPlace;
    private String firstName;
    private String lastName;

    public Occupant(int idPlace, String firstName, String lastName) {
        this.idPlace = idPlace;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }   
}

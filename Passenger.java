// Student ID#: 816031615

import java.util.Random;

public class Passenger{                                              
    // Attributes
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage;
    private char cabinClass; 
    
    // Contructor that initializes the instance variables
    public Passenger(String passportNumber, String firstName, String lastName, String flightNo)
    {
        this.passportNumber = passportNumber;
        this.flightNo = flightNo;
        this.firstName = firstName;
        this.lastName = lastName;
        assignRandomNumLuggage(); // Assigns a random number of luggage between 0 and 3 to the passenger
        assignRandomCabinClass(); // Assigns a random cabin class (F, B, P, or r E) to the passenger
    }
    
    
    // Private helper method that generates a random number of luggage to the passenger
    private void assignRandomNumLuggage() 
    {
      Random numLuggagePieces = new Random();
      this.numLuggage = numLuggagePieces.nextInt(4); // generates a random number between 0 and 3 inclusive 
    }

        
    // Helper method that allocates a random cabin class to the passenger
    private static final char[] CABIN_CLASSES = {'F', 'B', 'P', 'E'};
    private Random cabin = new Random();

    private void assignRandomCabinClass() {
        this.cabinClass = CABIN_CLASSES[cabin.nextInt(CABIN_CLASSES.length)];
    }

    
    // Method returns the string representation of the passenger
    public String toString() 
    {
        return "PP NO. " + getPassportNumber() + " NAME: " + getFirstName().charAt(0) + "." 
        + getLastName().toUpperCase() + " " +  "NUMLUGGAGE: " + getNumLuggage() + " CLASS: " + getCabinClass();
    }

    
    // Accessors for all attributes
    public String getPassportNumber() 
    { 
        return passportNumber;
    }
    
    public String getFlightNo() 
    {
        return flightNo;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }
    
    public String getLastName() 
    {
        return lastName;
    }
    
    public int getNumLuggage() 
    {
        return numLuggage;
    }
    
    public char getCabinClass() 
    {
        return cabinClass;
    }

}

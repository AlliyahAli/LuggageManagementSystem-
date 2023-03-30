// Student ID#: 816031615

import java.time.LocalDateTime;

public class Flight{
    // Attributes
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LuggageManifest manifest;

    // Constructor
    public Flight(String flightNo, String destination, String origin, LocalDateTime flightDate)
    {   
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        this.manifest = new LuggageManifest();
    }
    
    // Method checks the validity of the passengers' flight no. and adds the luggage to flight or displays "Invalid flight" otherwise
    public String checkInLuggage(Passenger p) 
    {
        if (p.getFlightNo().equals(getFlightNo())) {
        return manifest.addLuggage(p, this); // using 'this' allows the use of the instance of Flight being called on by the method
        }
        else
            return "Invalid flight\n";
    }
    
    // Method returns a string representation of the manifest
    public String printLuggageManifest()
    {   
        return manifest.toString(); 
    }

    // Method determines and returns the number of allowed luggage for a given cabin class
    public static int getAllowedLuggage(char cabinClass)
    {   
        switch(cabinClass){
            case 'F':
                return 3;
            case 'B':
                return 2;
            case 'P':
                return 1;
            case 'E':
                return 0;
            default:
                return 0;
            
        }
    }
    
    // Method returns a string representation of the Flight
    public String toString()
    {
        String flightOutput = getFlightNo() +  " DESTINATION: " + getDestination() + " ORIGIN: " + getOrigin() + " " + 
        getFlightDate().toString();
        return flightOutput;
    }
    
    // Accessors for all attributes
    public String getFlightNo(){
        return flightNo;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public String getOrigin(){
        return origin;
    }
    
    public LocalDateTime getFlightDate(){
        return flightDate;
    }

    private LuggageManifest getManifest(){
        return manifest;
    }
    
}


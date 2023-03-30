// Student ID#: 816031615

public class LuggageSlip
{   
    // Attributes
    private Passenger owner; 
    private static int luggageSlipIDCounter = 1;
    private String luggageSlipID;
    private String label;
    
    
    // Constructor (without label)
    public LuggageSlip(Passenger p, Flight f)
    {
        this.owner = p;
        this.luggageSlipID = f.getFlightNo() + "_" + p.getLastName() + "_" + getLuggageSlipIDCounter();
        this.label = "";
        luggageSlipIDCounter++;
    }
    
    //Overloaded constructor (with label)
    public LuggageSlip(Passenger p, Flight f, String label)
    {
        this.owner = p;
        this.luggageSlipID = f.getFlightNo() + "_" + p.getLastName() + "_" + getLuggageSlipIDCounter();
        this.label = label;
        luggageSlipIDCounter++;
    }
    

    // Method returns true if the owner of the luggage slip has the same passport no. as the one supplied
    public boolean hasOwner(String passportNumber) 
    {
        if(getOwner().getPassportNumber().equals(passportNumber)){ //checks if the owner of the luggage slip matches the provided passport number
            return true;
        }
        return false;
    }

    // Method displays the luggage slip information
    public String toString() 
    {
        String slipOutput = getLuggageSlipID() + " " + getOwner().toString();
            if (!getLabel().isEmpty()) {
              slipOutput = slipOutput + " " + getLabel();
            }
    
        return slipOutput;
    }
    
    // Accessors for all attributes
    public Passenger getOwner(){
        return owner;
    }
    
    public String getLuggageSlipID(){
        return luggageSlipID;
    }
    
    public static int getLuggageSlipIDCounter() {
       return luggageSlipIDCounter; //returns the current luggageSlipID
    }
    
    public String getLabel(){
        return label;
    }
    
}


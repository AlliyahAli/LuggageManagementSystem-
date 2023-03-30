// Student ID#: 816031615

import java.util.ArrayList;

public class LuggageManifest
{
    //ArrayList of luggageSlips
    private ArrayList<LuggageSlip> slips;
    
    // Constructor
    public LuggageManifest()
    {
        slips = new ArrayList<LuggageSlip>(); // initialize the slips collection
    }
    
    // Method adds the LuggageSlip object to the ArrayList
    public String addLuggage(Passenger p, Flight f)
    {
        int numPieces = p.getNumLuggage(); // get the number of luggage pieces 
        int numAllowedPieces = f.getAllowedLuggage(p.getCabinClass()); // gets the number of allowed luggage pieces based on cabin class
        double excessCost = 0.00;
        
        // Checks if the passenger has no luggage
        if(numPieces == 0){
            return "No Luggage to add.\n";
        }
       
        excessCost = getExcessLuggageCost(numPieces, numAllowedPieces); // calculates the excess luggage cost

        // Adds LuggageSlip objects to the ArrayList with label
        for (int i = 0; i < numPieces; i++) {
              String excessCostLabel = "$" + excessCost;
              LuggageSlip slip = new LuggageSlip(p, f, excessCostLabel);
              slips.add(slip);
        }
        return "Pieces Added: (" + numPieces + "). Excess Cost: $" + String.format("%.2f",excessCost) + "\n";         
    }
    
    // Method calculates the excess luggage cost
    public double getExcessLuggageCost(int numPieces, int numAllowedPieces)
    {
        if(numPieces <= numAllowedPieces){
            return 0; 
        }
        
        double excessCost = (numPieces - numAllowedPieces) * 35.00;
        return excessCost;
    }
    
    
    // Method calculates the total excess luggage cost for a specific passenger
    public String getExcessLuggageCostByPassenger(String passportNumber)
    {
        double totalExcessCost = 0.0;
        
        for(LuggageSlip slip : slips)
        {
           if(slip.getOwner().getPassportNumber().equals(passportNumber)){
               
                int numPieces = slip.getOwner().getNumLuggage();
                int numAllowedPieces;
                
                if(slip.getOwner().getCabinClass() == 'F'){
                    numAllowedPieces = 3;
                }
                else if(slip.getOwner().getCabinClass() == 'B'){
                    numAllowedPieces = 2;
                }
                else if(slip.getOwner().getCabinClass() == 'P'){
                    numAllowedPieces = 1;
                }
                else{
                    numAllowedPieces = 0;
                }
                
                totalExcessCost += getExcessLuggageCost(numPieces,numAllowedPieces);
                
                return "Excess Cost: " + totalExcessCost;
                
                }
           }
           return "No Cost";
        }
    
    // Method returns a string representation of the aggregated state of the LuggageManifest
    public String toString()
    {
        String output = "LUGGAGE MANIFEST:\n";
        
        for (LuggageSlip slip : slips) {
        output += slip.toString() + "\n";
        }
        return output;
    }
}

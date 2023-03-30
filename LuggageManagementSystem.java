// Student ID#: 816031615

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Random;


public class LuggageManagementSystem {
    public static void main(String[] args) {
        LocalDateTime d = LocalDateTime.of(2023, 1, 23, 10, 00, 00);
        String fileName1 = "Flights.txt";
        String line;
        Flight flight = null;
    
        try (BufferedReader br = new BufferedReader(new FileReader(fileName1))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                String flightNo = values[0];
                String destination = values[1];
                String origin = values[2];
                
                flight = new Flight(flightNo, destination, origin, d);
                System.out.println(flight);               
            }
        } catch (Exception e) {
        
        }
    
        System.out.print("\n");
        String fileName2 = "Passengers.txt";
        Random random = new Random();
        String[] flightNumbers = {"BW6001","BW6982"};
            
        try (BufferedReader br = new BufferedReader(new FileReader(fileName2))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                String name = values[0];
                String passportNumber = values[1];
                String destination = values[2];
        
                int randomIndex = random.nextInt(flightNumbers.length);
                String flightNo = flightNumbers[randomIndex];
        
                Passenger passenger = new Passenger(name, passportNumber, destination, flightNo);
                System.out.println(passenger);
                System.out.println(flight.checkInLuggage(passenger));
             
                }
        } catch (Exception e) {    
          }
            
        System.out.println(flight.printLuggageManifest()); 
    }
}

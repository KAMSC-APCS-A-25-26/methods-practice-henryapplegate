import java.util.Scanner;
import java.text.DecimalFormat;

public class TripPlanner {
    public static void main(String[] args) {
        // TODO: Get user input for trip details
        // - Distance (miles)
        // - Average speed (mph)
        // - Fuel efficiency (miles per gallon)
        // - Fuel price per gallon
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.print("Enter trip distance (miles): ");
        double distance = sc.nextDouble();
        System.out.print("Enter avergage speed (mph): ");
        double speed = sc.nextDouble();
        System.out.print("Enter fuel efficiency (miles per gallon): ");
        double efficiency = sc.nextDouble();
        System.out.print("Enter fuel price per gallon ($): ");
        double price = sc.nextDouble();
        String time = df.format(calculateTravelTime(distance, speed));
        String fuel = df.format(calculateFuelNeeded(distance, efficiency));
        String cost = df.format(calculateTripCost(distance, efficiency, price));
        displayResults(time, fuel, cost);

        // TODO: Calculate travel time using a return method
        
        // TODO: Calculate fuel needed using a return method
        
        // TODO: Calculate trip cost using a return method
        
        // TODO: Display results using a void method
        
    }
    
    // TODO: Implement calculateTravelTime method
    public static double calculateTravelTime(double distance, double speed){
        return distance/speed;
    }
    
    // TODO: Implement calculateFuelNeeded method
    public static double calculateFuelNeeded(double distance, double efficiency){
        return distance/efficiency;
    }
    
    // TODO: Implement calculateTripCost method
    public static double calculateTripCost(double distance, double efficiency, double price){
        return (distance/efficiency) * price;
    }
    // TODO: Implement displayResults method
    public static void displayResults(String time, String fuel, String cost){
        System.out.println("\nResults:");
        System.out.println("Travel Time: " + time + " hours");
        System.out.println("Fuel Needed: " + fuel + " gallons");
        System.out.println("Trip Cost: $" + cost);
    }
    
}

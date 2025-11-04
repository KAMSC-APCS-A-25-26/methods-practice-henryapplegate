[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/j5x62eEz)
# Methods Practice Assignment

## Trip Planner

### Objective
Practice creating and using methods in Java, including return methods and void methods.

### Description
Write a program that helps users plan a trip by calculating travel time, fuel needed, and trip cost based on user input.

The program should:
- Get user input for trip distance, average speed, fuel efficiency, and fuel price
- Calculate travel time using a return method
- Calculate fuel needed using a return method
- Calculate trip cost using a return method
- Display results using a void method

### Expected Output (example)
```
Enter trip distance (miles): 300
Enter average speed (mph): 60
Enter fuel efficiency (miles per gallon): 25
Enter fuel price per gallon ($): 3.50

Results:
Travel Time: 5.00 hours
Fuel Needed: 12.00 gallons
Trip Cost: $42.00
```

## Requirements

### Required Components:

1. **Four Methods to Implement:**
   - `calculateTravelTime()`
     - Calculates and returns travel time in hours
   - `calculateFuelNeeded()` 
     - Calculates and returns gallons of fuel needed
   - `calculateTripCost()`
     - Calculates and returns total cost in dollars 
   - `displayResults()`
     - Displays formatted output showing all three values

2. **Main Method Requirements:**
   - Get user input for:
     - Trip distance (miles)
     - Average speed (mph)
     - Fuel efficiency (miles per gallon)
     - Fuel price per gallon ($)
   - Call all three calculation methods and store their return values
   - Call the `displayResults()` method to show the results
   - Close the Scanner

3. **Method Signatures:**
   - All methods must be `public static`
   - Return methods must have return type 
   - Display method shoud output results
   - Use appropriate parameter types


## Example Calculations

### Example 1:
- **Input:** 300 miles, 60 mph, 25 mpg, $3.50/gal
- **Travel Time:** 5.00 hours
- **Fuel Needed:** 12.00 gallons
- **Trip Cost:** $42.00

### Example 2:
- **Input:** 500 miles, 70 mph, 30 mpg, $4.00/gal
- **Travel Time:** 7.14 hours
- **Fuel Needed:** 16.67 gallons
- **Trip Cost:** $66.67




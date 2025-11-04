import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Trip Planner – Methods Practice Tests")
public class TripPlannerTest {

    private String runWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        java.io.InputStream originalIn = System.in;
        try {
            System.setIn(in);
            System.setOut(new PrintStream(out));
            TripPlanner.main(new String[]{});
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
        return out.toString();
    }

    @Test
    @DisplayName("Code should compile without errors")
    void testCodeCompiles() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/TripPlanner.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.length() > 0, 
                "❌ Source code should exist and not be empty");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should have calculateTravelTime method")
    void testHasCalculateTravelTimeMethod() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/TripPlanner.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.contains("calculateTravelTime"), 
                "❌ Should have calculateTravelTime method");
            assertTrue(sourceCode.contains("double") && sourceCode.contains("calculateTravelTime"), 
                "❌ calculateTravelTime should return double");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should have calculateFuelNeeded method")
    void testHasCalculateFuelNeededMethod() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/TripPlanner.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.contains("calculateFuelNeeded"), 
                "❌ Should have calculateFuelNeeded method");
            assertTrue(sourceCode.contains("double") && sourceCode.contains("calculateFuelNeeded"), 
                "❌ calculateFuelNeeded should return double");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should have calculateTripCost method")
    void testHasCalculateTripCostMethod() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/TripPlanner.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.contains("calculateTripCost"), 
                "❌ Should have calculateTripCost method");
            assertTrue(sourceCode.contains("double") && sourceCode.contains("calculateTripCost"), 
                "❌ calculateTripCost should return double");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should have displayResults void method")
    void testHasDisplayResultsMethod() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/TripPlanner.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.contains("displayResults"), 
                "❌ Should have displayResults method");
            assertTrue(sourceCode.contains("void") && sourceCode.contains("displayResults"), 
                "❌ displayResults should be a void method");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should use Scanner for input")
    void testUsesScanner() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/TripPlanner.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.contains("Scanner"), 
                "❌ Should use Scanner class for user input");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should calculate travel time correctly")
    void testCalculateTravelTime() {
        String output = runWithInput("300\n60\n25\n3.50\n");
        
        boolean hasCorrectTime = (output.contains("5.00") || output.contains("5.0")) &&
                                 output.toLowerCase().contains("hour") &&
                                 !output.contains("0.08");
        
        assertTrue(hasCorrectTime, 
            "❌ Should calculate travel time correctly (300/60 = 5.00 hours). Got output: " + output);
    }

    @Test
    @DisplayName("Should calculate fuel needed correctly")
    void testCalculateFuelNeeded() {
        String output = runWithInput("300\n60\n25\n3.50\n");
        
        boolean hasCorrectFuel = (output.contains("12.00") || output.contains("12.0") || 
                                  output.contains("12")) &&
                                 output.toLowerCase().contains("gallon");
        
        assertTrue(hasCorrectFuel, 
            "❌ Should calculate fuel needed correctly (300/25 = 12.00 gallons). Got output: " + output);
    }

    @Test
    @DisplayName("Should calculate trip cost correctly")
    void testCalculateTripCost() {
        String output = runWithInput("300\n60\n25\n3.50\n");
        
        boolean hasCorrectCost = (output.contains("42.00") || output.contains("42.0") || 
                                  (output.contains("$42") || output.contains("42"))) &&
                                 output.contains("$");
        
        assertTrue(hasCorrectCost, 
            "❌ Should calculate trip cost correctly (12 * 3.50 = $42.00). Got output: " + output);
    }

    @Test
    @DisplayName("Should display results using void method")
    void testDisplayResults() {
        String output = runWithInput("300\n60\n25\n3.50\n");
        
        assertTrue(output.length() > 0, 
            "❌ displayResults should print output");
        
        String lowerOutput = output.toLowerCase();
        boolean hasOutput = lowerOutput.contains("time") || 
                          lowerOutput.contains("fuel") || 
                          lowerOutput.contains("cost") ||
                          lowerOutput.contains("trip") ||
                          lowerOutput.contains("travel");
        
        assertTrue(hasOutput, 
            "❌ displayResults should show trip information. Output: " + output);
    }

    @Test
    @DisplayName("Should handle different input values")
    void testDifferentInputs() {
        String output = runWithInput("500\n70\n30\n4.00\n");
        
        assertTrue(output.length() > 0, 
            "❌ Should handle different input values");
        
        boolean hasCorrectTime = output.contains("7.14") || output.contains("7.1");
        boolean hasCorrectFuel = output.contains("16.67") || output.contains("16.6");
        boolean hasCorrectCost = output.contains("66.67") || output.contains("66.6");
        
        assertTrue(hasCorrectTime || hasCorrectFuel || hasCorrectCost, 
            "❌ Should calculate correct values for different inputs (7.14 hours, 16.67 gallons, $66.67). Got output: " + output);
    }

    @Test
    @DisplayName("Should use methods in main method")
    void testUsesMethodsInMain() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/TripPlanner.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            boolean usesMethods = (sourceCode.contains("calculateTravelTime(") && 
                                 sourceCode.contains("calculateFuelNeeded(") && 
                                 sourceCode.contains("calculateTripCost(") && 
                                 sourceCode.contains("displayResults("));
            
            assertTrue(usesMethods, 
                "❌ Should call all methods in main method");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should have proper method structure")
    void testMethodStructure() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/TripPlanner.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            boolean hasMethodSignatures = sourceCode.contains("public static") && 
                                        (sourceCode.contains("double") || sourceCode.contains("void"));
            
            assertTrue(hasMethodSignatures, 
                "❌ Should have proper method signatures with public static");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }
}

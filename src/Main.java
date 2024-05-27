import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Create a Restaurant
        Restaurant restaurant = new Restaurant("Gourmet Bistro");

        // Create some Tables
        Table table1 = new Table(1, 4);
        Table table2 = new Table(2, 2);
        Table table3 = new Table(3, 6);

        // Add Tables to the Restaurant
        restaurant.addTable(table1);
        restaurant.addTable(table2);
        restaurant.addTable(table3);

        // Print the Restaurant details
        System.out.println("After adding tables: " + restaurant);

        // Save the state to a file
        try {
            restaurant.saveState("state.csv");
            System.out.println("State saved to state.csv");
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }

        // Restore the state from the file
        Restaurant newRestaurant = new Restaurant("New Bistro");
        try {
            newRestaurant.restoreState("state.csv");
            System.out.println("State restored from state.csv");
        } catch (IOException e) {
            System.out.println("Error restoring state: " + e.getMessage());
        }

        // Print the restored Restaurant details
        System.out.println(newRestaurant);
    }
}

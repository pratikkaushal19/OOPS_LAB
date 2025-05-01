import java.util.HashMap;
import java.util.Map;

public class ProductInventory {

    public static void main(String[] args) {
        // Create a HashMap to store productId as key and quantity as value
        HashMap<Integer, Integer> inventory = new HashMap<>();

        // Add three products
        inventory.put(1001, 50);  // Product ID 1001 with quantity 50
        inventory.put(1002, 30);  // Product ID 1002 with quantity 30
        inventory.put(1003, 20);  // Product ID 1003 with quantity 20

        // Update quantity of product with ID 1002
        inventory.put(1002, 45);  // New quantity is 45
        System.out.println("Updated quantity for product ID 1002.");

        // Remove product with ID 1001
        inventory.remove(1001);
        System.out.println("Removed product ID 1001 from inventory.");

        // Display final inventory
        System.out.println("\nFinal Inventory:");
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
}

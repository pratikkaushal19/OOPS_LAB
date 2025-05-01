import java.util.HashSet;

public class UniqueNames {

    public static void main(String[] args) {
        // Array of names with duplicates
        String[] names = {"Aman", "Varun", "Sourabh", "Varun", "Aman"};

        // Create a HashSet to store unique names
        HashSet<String> uniqueNames = new HashSet<>();

        // Add names to the HashSet (duplicates will be automatically removed)
        for (String name : names) {
            uniqueNames.add(name);
        }

        // Check if a specific name exists in the HashSet
        String searchName = "Varun";
        if (uniqueNames.contains(searchName)) {
            System.out.println(searchName + " exists in the set.");
        } else {
            System.out.println(searchName + " does not exist in the set.");
        }

        // Print the unique names
        System.out.println("\nUnique names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}

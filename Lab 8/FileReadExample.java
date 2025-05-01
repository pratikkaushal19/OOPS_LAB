import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadExample {

    // Method to read a file, throws FileNotFoundException
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        // Reading and printing file content
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = inputScanner.nextLine();

        try {
            // Attempt to read the file
            readFile(fileName);
        } catch (FileNotFoundException e) {
            // Handle exception if the file is not found
            System.out.println("Error: The file '" + fileName + "' was not found.");
        } finally {
            // Ensure this message is always printed
            System.out.println("File operation attempted.");
        }

        inputScanner.close();
    }
}
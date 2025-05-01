import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WordCharacterCounter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the text file: ");
        String fileName = input.nextLine();

        int wordCount = 0;
        int charCount = 0;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                // Count words
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }

                // Count non-whitespace characters
                charCount += line.replaceAll("\\s+", "").length();
            }

            br.close();
            fr.close();

            System.out.println("Total words: " + wordCount);
            System.out.println("Total characters (excluding whitespace): " + charCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + fileName + "' not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        input.close();
    }
}

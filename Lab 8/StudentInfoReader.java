import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentInfoReader {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("student.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            System.out.println("Student Information:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'student.txt' was not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

import java.util.*;
public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your marks for the first subject: ");
        int gr1 = sc.nextInt();
        System.out.println("Enter your marks for the second subject: ");
        int gr2 = sc.nextInt();
        System.out.println("Enter your marks for the third subject: ");
        int gr3 = sc.nextInt();

        int avg = (gr1 + gr2 + gr3)/3;

        if(avg >= 90){
            System.out.println("Grade: A");
        }
        else if(avg >= 75 && avg < 90){
            System.out.println("Grade B");
        }
        else if(avg >= 50 && avg < 50){
            System.out.println("Grade C");
        }
        else{
            System.out.println("Grade F");
        }
        
    }
}

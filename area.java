import java.util.Scanner;

public class area {

    public static double area(double length, double breadth) {
        return length * breadth;
    }


    public static double area(double side) {
        return side * side;
    }


    public static double areaCircle(double radius) {
        return 3.14 * radius * radius;
    }


    public static double areaTriangle(double base, double height) {
        return 0.5 * base * height; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the shape to calculate the area:");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.println("4. Triangle");

        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: // Rectangle
                System.out.print("Enter the length of the rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter the breadth of the rectangle: ");
                double breadth = scanner.nextDouble();
                System.out.println("Area of Rectangle: " + area(length, breadth));
                break;

            case 2: // Square
                System.out.print("Enter the side of the square: ");
                double side = scanner.nextDouble();
                System.out.println("Area of Square: " + area(side));
                break;

            case 3: // Circle
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                System.out.println("Area of Circle: " + areaCircle(radius));
                break;

            case 4: // Triangle
                System.out.print("Enter the base of the triangle: ");
                double base = scanner.nextDouble();
                System.out.print("Enter the height of the triangle: ");
                double height = scanner.nextDouble();
                System.out.println("Area of Triangle: " + areaTriangle(base, height));
                break;

            default: // Invalid choice
                System.out.println("Invalid choice! Please enter a number between 1 and 4.");
        }

        scanner.close();
    }
}
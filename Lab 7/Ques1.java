abstract class Shape {
    // Abstract method to calculate area
    abstract void calculateArea();
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    void calculateArea() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

public class Ques1 {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(9.0, 15.0);
        rectangle.calculateArea();

        Shape circle = new Circle(9.0);
        circle.calculateArea();
    }
}
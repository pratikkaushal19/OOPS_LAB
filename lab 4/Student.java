class Student {
    String name;
    int age;

    // Default Constructor
    public Student() {
        name = "Ram";
        age = 18;
    }

    // Parameterized Constructor
    public Student(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Creating an object using the default constructor
        Student student1 = new Student();
        System.out.println("Student 1 Details:");
        student1.displayDetails();

        System.out.println(); // This line is fine if you want a blank line

        // Creating an object using the parameterized constructor
        Student student2 = new Student("Sita", 20);
        System.out.println("Student 2 Details:");
        student2.displayDetails();
    }
}

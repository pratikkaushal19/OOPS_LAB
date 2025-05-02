class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double salary;
    private static int totalEmployees = 0; // Static variable to track total employees

    // Default constructor
    public Employee() {
        this.employeeID = 0;
        this.name = "Unknown";
        this.department = "Not Assigned";
        this.salary = 0.0;
        totalEmployees++; // Increment total employees
    }

    // Parameterized constructor
    public Employee(int employeeID, String name, String department, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.salary = salary;
        totalEmployees++; // Increment total employees
    }

    // Getter method for salary
    public double getSalary() {
        return this.salary;
    }

    // Method to calculate salary (returns the salary of the employee)
    public double calculateSalary() {
        return this.salary;
    }

    // Method to display employee details
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }

    // Static method to display total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating Employee objects using both constructors
        Employee emp1 = new Employee();
        Employee emp2 = new Employee(101, "Arnav", "HR", 50000);
        Employee emp3 = new Employee(102, "Krish", "IT", 70000);
        Employee emp4 = new Employee(103, "Tanvir", "Finance", 60000);

        // Display individual employee details
        emp1.displayEmployeeInfo();
        emp2.displayEmployeeInfo();
        emp3.displayEmployeeInfo();
        emp4.displayEmployeeInfo();

        // Display total number of employees
        Employee.displayTotalEmployees();
    }
}

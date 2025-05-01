import java.util.ArrayList;

// Employee class definition
class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
    }
}

// Public class with a new name
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create an ArrayList of Employee
        ArrayList<Employee> employees = new ArrayList<>();

        // Add three employees
        employees.add(new Employee("Alice", 101, 50000));
        employees.add(new Employee("Bob", 102, 55000));
        employees.add(new Employee("Charlie", 103, 60000));

        // Update salary of employee with id 102
        for (Employee emp : employees) {
            if (emp.id == 102) {
                emp.salary = 58000; // new salary
                System.out.println("Updated salary for Bob.");
                break;
            }
        }

        // Remove employee with id 101
        employees.removeIf(emp -> emp.id == 101);
        System.out.println("Removed employee with ID 101.");

        // Print remaining employees
        System.out.println("\nRemaining Employees:");
        for (Employee emp : employees) {
            emp.display();
        }
    }
}

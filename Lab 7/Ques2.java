;
		abstract class employee {
		     String name;
		     String role;
		    
		    public employee(String name, String role) {
		        this.name = name;
		        this.role = role;
		    }
		    
		    
		    abstract double calculateSalary();
		    abstract void displayDetails();
		}

		class Manager extends employee {
		    private double fixedSalary;
		    
		    public Manager(String name, double fixedSalary) {
		        super(name, "Manager");
		        this.fixedSalary = fixedSalary;
		    }
		    
		   
		    double calculateSalary() {
		        return fixedSalary;
		    }
		    
		    
		    void displayDetails() {
		        System.out.println("Name: " + name);
		        System.out.println("Role: " + role);
		        System.out.println("Salary: $" + calculateSalary());
		    }
		}

		class Developer extends employee {
		     double hourlyRate;
		    int hoursWorked;
		    
		    public Developer(String name, double hourlyRate, int hoursWorked) {
		        super(name, "Developer");
		        this.hourlyRate = hourlyRate;
		        this.hoursWorked = hoursWorked;
		    }
		    
		   
		    double calculateSalary() {
		        return hourlyRate * hoursWorked;
		    }
		    
		   
		    void displayDetails() {
		        System.out.println("Name: " + name);
		        System.out.println("Role: " + role);
		        System.out.println("Salary: $" + calculateSalary());
		    }
		}

		public class Ques2 {
		    public static void main(String[] args) {
		        employee obj1 = new Manager("Alice", 5000.0);
		        obj1.displayDetails();
		        
		        System.out.println();
		        
		        employee obj2 = new Developer("Bob", 50.0, 160);
		        obj2.displayDetails();
		    }
		}
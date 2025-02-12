class Vehicle {
    String brand;
    String model;
    double price;

    public Vehicle(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: " + price);
    }
}

class Car extends Vehicle {
    int seatingCapacity;
    String fuelType;

    public Car(String brand, String model, double price, int seatingCapacity, String fuelType) {
        super(brand, model, price);
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seating Capacity: " + seatingCapacity + ", Fuel Type: " + fuelType);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;
    int chargingTime;

    public ElectricCar(String brand, String model, double price, int seatingCapacity, String fuelType, int batteryCapacity, int chargingTime) {
        super(brand, model, price, seatingCapacity, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh, Charging Time: " + chargingTime + " hours");
    }
}

class Motorcycle extends Vehicle {
    int engineCapacity;
    String type;

    public Motorcycle(String brand, String model, double price, int engineCapacity, String type) {
        super(brand, model, price);
        this.engineCapacity = engineCapacity;
        this.type = type;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity + " cc, Type: " + type);
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Hycross", 3000000, 7, "Hybrid");
        ElectricCar electricCar = new ElectricCar("Tata", "Nexon", 500000, 5, "Electric", 100, 2);
        Motorcycle motorcycle = new Motorcycle("Hero Honda", "Splendor", 75000, 750, "Cruiser");

        car.displayDetails();
        System.out.println();
        electricCar.displayDetails();
        System.out.println();
        motorcycle.displayDetails();
    }
}
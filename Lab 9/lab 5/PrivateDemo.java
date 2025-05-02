class SuperClass {
    private int privateVar = 10;
    public int getPrivateVar() {
        return privateVar;
    }
}

class SubClass extends SuperClass {
    public void display() {
        System.out.println("Accessing private member via getter: " + getPrivateVar());
    }
}

public class PrivateDemo {
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.display();
    }
}
import java.io.*;


class Person implements Serializable {
    private static final long serialVersionUID = 1L; // For version control

    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // To display object content
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class PersonSerializationDemo {

    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("John", 30);

        // Serialize the object to person.txt
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            oos.writeObject(person);
            System.out.println("Person object serialized to 'person.txt'.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialize the object from person.txt
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("\nDeserialized Person object:");
            deserializedPerson.displayInfo();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}

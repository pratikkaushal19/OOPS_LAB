import java.util.ArrayList;

public class PrimeChecker {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Autoboxing: adding primitive ints into an ArrayList<Integer>
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(16);
        numbers.add(17);
        numbers.add(19);
        numbers.add(20);

        // Iterate and check for primes
        for (Integer num : numbers) {
            int value = num; // unboxing
            if (isPrime(value)) {
                System.out.println(value + " is a prime number.");
            } else {
                System.out.println(value + " is not a prime number.");
            }
        }
    }
}

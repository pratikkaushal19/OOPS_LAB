interface Bank {
    void deposit(double amount);
    void withdraw(double amount);
}

class Account implements Bank {
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Account account = new Account(1000);  // Create an account with $1000 initial balance
        System.out.println("Initial Balance: $" + account.getBalance());

        // Deposit some money
        account.deposit(500);

        // Withdraw some money
        account.withdraw(200);

        // Attempt to withdraw more than available balance
        account.withdraw(1500);

        // Display the final balance
        System.out.println("Final Balance: $" + account.getBalance());
    }
}

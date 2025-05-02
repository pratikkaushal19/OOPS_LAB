public class BankAccount {

    private double balance;
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    
    protected void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }


    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000);
        

        myAccount.deposit(50);
        
    
        myAccount.withdraw(100.0);
        

        myAccount.checkBalance();
    }
}
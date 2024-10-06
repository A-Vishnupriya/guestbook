import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: $0.0");
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount + " | Balance: $" + balance);
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount + " | Balance: $" + balance);
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Transaction failed.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History for account: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        System.out.println("Enter account holder name: ");
        String accountHolder = scanner.nextLine();
        
        BankAccount account = new BankAccount(accountNumber, accountHolder);
        
        int choice;
        do {
            System.out.println("\nBank Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + account.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    account.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the bank system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}

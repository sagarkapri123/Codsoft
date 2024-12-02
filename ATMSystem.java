import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Class to represent the ATM
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public void handleUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                withdraw(scanner);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: %.2f\n", account.getBalance());
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount. Withdrawal failed.");
        }
    }
}

// Main class
public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);

        int choice;
        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            atm.handleUserChoice(choice, scanner);
        } while (choice != 4);

        scanner.close();
    }
}

import java.util.Scanner;

class BankAccount {
    String accountHolderName;
    int accountNumber;
    double balance;

    // Constructor
    public BankAccount(String accountHolderName, int accountNumber, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
    }

    // Method to display account details
    public void displayAccountDetails() {
 

        System.out.println(String.format("Balance: ₹%.2f", balance));
    }
}

class SavingsAccount extends BankAccount {
    // Constructor
    public SavingsAccount(String accountHolderName, int accountNumber, double initialDeposit) {
        super(accountHolderName, accountNumber, initialDeposit);
    }

    // Additional methods specific to SavingsAccount can be added here
}

class CurrentAccount extends BankAccount {
    double overdraftLimit;

    // Constructor
    public CurrentAccount(String accountHolderName, int accountNumber, double initialDeposit, double overdraftLimit) {
        super(accountHolderName, accountNumber, initialDeposit);
        this.overdraftLimit = overdraftLimit;
    }

    // Method to display account details including overdraft limit
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println(String.format("Overdraft Limit: ₹%.2f", overdraftLimit));
    }

    // Additional methods specific to CurrentAccount can be added here
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input account type
        
        String accountType = scanner.nextLine().trim();

    
        String accountHolderName = scanner.nextLine().trim();


        int accountNumber = scanner.nextInt();

        double initialDeposit = scanner.nextDouble();

        // Account creation based on type
        if (accountType.equalsIgnoreCase("SavingsAccount")) {
            SavingsAccount savingsAccount = new SavingsAccount(accountHolderName, accountNumber, initialDeposit);
            System.out.println("Account Created: SavingsAccount for " + savingsAccount.accountHolderName 
                               + " with Account Number " + savingsAccount.accountNumber);
            savingsAccount.displayAccountDetails();

        } else if (accountType.equalsIgnoreCase("CurrentAccount")) {
            
            double overdraftLimit = scanner.nextDouble();

            CurrentAccount currentAccount = new CurrentAccount(accountHolderName, accountNumber, initialDeposit, overdraftLimit);
            System.out.println("Account Created: CurrentAccount for " + currentAccount.accountHolderName 
                               + " with Account Number " + currentAccount.accountNumber);
            currentAccount.displayAccountDetails();

        } else {
            System.out.println("Invalid Account Type. Please enter either SavingsAccount or CurrentAccount.");
        }

        scanner.close();
    }
}

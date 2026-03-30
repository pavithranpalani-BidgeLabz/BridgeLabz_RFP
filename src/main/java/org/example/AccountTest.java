import java.util.*;

public class AccountTest {

    // ─── Account Class ────────────────────────────────────────────────
    static class Account {
        String name;
        double balance;

        // Constructor
        Account(String name, double initialBalance) {
            this.name = name;
            if (initialBalance > 0)
                this.balance = initialBalance;
            else {
                this.balance = 0;
                System.out.println("Invalid initial balance. Set to 0.");
            }
        }

        // Credit Method – Add money to account
        void credit(double amount) {
            if (amount <= 0) {
                System.out.println("Credit amount must be positive.");
                return;
            }
            balance += amount;
            System.out.printf("Credited : %.2f | New Balance : %.2f%n", amount, balance);
        }

        // Debit Method – Withdraw money from account
        void debit(double amount) {
            if (amount <= 0) {
                System.out.println("Debit amount must be positive.");
                return;
            }
            if (amount > balance) {
                System.out.println("Debit amount exceeded account balance.");
                System.out.printf("Current Balance : %.2f | Attempted Debit : %.2f%n",
                        balance, amount);
            } else {
                balance -= amount;
                System.out.printf("Debited  : %.2f | New Balance : %.2f%n", amount, balance);
            }
        }

        // Get Balance
        double getBalance() {
            return balance;
        }

        // Get Name
        String getName() {
            return name;
        }

        // Display Account Details
        void displayAccount() {
            System.out.printf("%-20s | Balance : %.2f%n", name, balance);
        }
    }

    // ─── Main (AccountTest) ───────────────────────────────────────────
    static Scanner scanner = new Scanner(System.in);
    static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Welcome to Account Management System ===");

        while (true) {
            System.out.println("\n======= MAIN MENU =======");
            System.out.println("1. Create Account");
            System.out.println("2. Credit Amount");
            System.out.println("3. Debit Amount");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            String input = scanner.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(input); }
            catch (NumberFormatException e) { System.out.println("Invalid input."); continue; }

            switch (choice) {
                case 1: createAccount();      break;
                case 2: creditAccount();      break;
                case 3: debitAccount();       break;
                case 4: checkBalance();       break;
                case 5: displayAllAccounts(); break;
                case 6:
                    System.out.println("\nThank You! Goodbye.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // ─── Create Account ───────────────────────────────────────────────
    static void createAccount() {
        System.out.print("\nEnter Account Holder Name : ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Initial Balance     : ");
        double balance = readDouble();

        accounts.add(new Account(name, balance));
        System.out.println("Account created for '" + name + "' successfully!");
    }

    // ─── Credit Account ───────────────────────────────────────────────
    static void creditAccount() {
        Account acc = findAccount();
        if (acc == null) return;

        System.out.print("Enter Credit Amount : ");
        double amount = readDouble();
        acc.credit(amount);
    }

    // ─── Debit Account ────────────────────────────────────────────────
    static void debitAccount() {
        Account acc = findAccount();
        if (acc == null) return;

        System.out.print("Enter Debit Amount : ");
        double amount = readDouble();
        acc.debit(amount);
    }

    // ─── Check Balance ────────────────────────────────────────────────
    static void checkBalance() {
        Account acc = findAccount();
        if (acc == null) return;

        System.out.printf("Balance for '%s' : %.2f%n",
                acc.getName(), acc.getBalance());
    }

    // ─── Display All Accounts ─────────────────────────────────────────
    static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("\nNo accounts found.");
            return;
        }
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║         ALL ACCOUNTS SUMMARY             ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf( "║  %-20s | %-15s  ║%n", "Account Holder", "Balance");
        System.out.println("╠══════════════════════════════════════════╣");
        for (Account acc : accounts)
            System.out.printf("║  %-20s | %15.2f  ║%n", acc.getName(), acc.getBalance());
        System.out.println("╚══════════════════════════════════════════╝");
    }

    // ─── Helper: Find Account by Name ────────────────────────────────
    static Account findAccount() {
        if (accounts.isEmpty()) {
            System.out.println("\nNo accounts available.");
            return null;
        }
        System.out.println("\nAvailable Accounts:");
        for (int i = 0; i < accounts.size(); i++)
            System.out.printf("  %d. %s (Balance: %.2f)%n",
                    i + 1, accounts.get(i).getName(), accounts.get(i).getBalance());

        System.out.print("Enter Account Holder Name : ");
        String name = scanner.nextLine().trim();

        for (Account acc : accounts)
            if (acc.getName().equalsIgnoreCase(name)) return acc;

        System.out.println("Account not found for '" + name + "'.");
        return null;
    }

    // ─── Helper: Safe Double Input ────────────────────────────────────
    static double readDouble() {
        while (true) {
            try { return Double.parseDouble(scanner.nextLine().trim()); }
            catch (NumberFormatException e) {
                System.out.print("Invalid amount. Try again: ");
            }
        }
    }
}
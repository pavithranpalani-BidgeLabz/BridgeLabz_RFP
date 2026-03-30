import java.util.*;

public class StockAccountManagement {

    // ─── Stock Class ──────────────────────────────────────────────────
    static class Stock {
        String name;
        int    numberOfShares;
        double sharePrice;

        Stock(String name, int numberOfShares, double sharePrice) {
            this.name           = name;
            this.numberOfShares = numberOfShares;
            this.sharePrice     = sharePrice;
        }

        // Calculate value of this stock
        double calculateStockValue() {
            return numberOfShares * sharePrice;
        }

        public String toString() {
            return String.format("%-20s | Shares: %6d | Price: %8.2f | Value: %10.2f",
                    name, numberOfShares, sharePrice, calculateStockValue());
        }
    }

    // ─── Stock Portfolio Class ────────────────────────────────────────
    static class StockPortfolio {
        List<Stock> stocks = new ArrayList<>();

        // Add stock to portfolio
        void addStock(Stock stock) {
            stocks.add(stock);
        }

        // Calculate total value of all stocks
        double calculateTotalValue() {
            double total = 0;
            for (Stock s : stocks) total += s.calculateStockValue();
            return total;
        }

        // Print the full stock report
        void printStockReport() {
            if (stocks.isEmpty()) {
                System.out.println("\nNo stocks in portfolio.");
                return;
            }

            System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║               STOCK PORTFOLIO REPORT                        ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.printf( "║  %-18s | %-10s | %-10s | %-12s║%n",
                    "Stock Name", "Shares", "Price", "Total Value");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");

            for (Stock s : stocks) {
                System.out.printf("║  %-18s | %10d | %10.2f | %12.2f║%n",
                        s.name, s.numberOfShares, s.sharePrice, s.calculateStockValue());
            }

            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.printf( "║  %-43s %12.2f║%n",
                    "TOTAL PORTFOLIO VALUE :", calculateTotalValue());
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
        }
    }

    // ─── Main ─────────────────────────────────────────────────────────
    static Scanner      scanner   = new Scanner(System.in);
    static StockPortfolio portfolio = new StockPortfolio();

    public static void main(String[] args) {
        System.out.println("=== Welcome to Stock Account Management ===");

        while (true) {
            System.out.println("\n======= MAIN MENU =======");
            System.out.println("1. Add Stock");
            System.out.println("2. View Stock Report");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            String input = scanner.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(input); }
            catch (NumberFormatException e) { System.out.println("Invalid input."); continue; }

            switch (choice) {
                case 1: addStock();                   break;
                case 2: portfolio.printStockReport(); break;
                case 3:
                    System.out.println("\nThank You! Goodbye.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Read stock details from console and add to portfolio
    static void addStock() {
        System.out.print("\nHow many stocks do you want to add? ");
        int n;
        try { n = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Invalid number."); return; }

        for (int i = 1; i <= n; i++) {
            System.out.println("\n-- Stock " + i + " --");

            System.out.print("Stock Name       : ");
            String name = scanner.nextLine().trim();

            System.out.print("Number of Shares : ");
            int shares;
            try { shares = Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Invalid shares. Skipping."); continue; }

            System.out.print("Share Price      : ");
            double price;
            try { price = Double.parseDouble(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Invalid price. Skipping."); continue; }

            portfolio.addStock(new Stock(name, shares, price));
            System.out.println("Stock '" + name + "' added successfully!");
        }
    }
}
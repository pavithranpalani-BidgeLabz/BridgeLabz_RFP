import java.util.*;
import java.util.stream.*;

public class EmployeeWageComputation {

    // ─── Constants ────────────────────────────────────────────────────
    static final int WAGE_PER_HOUR     = 20;
    static final int FULL_DAY_HOURS    = 8;
    static final int PART_TIME_HOURS   = 4;
    static final int MAX_WORKING_DAYS  = 20;
    static final int MAX_WORKING_HOURS = 100;

    static final int IS_ABSENT    = 0;
    static final int IS_FULL_TIME = 1;
    static final int IS_PART_TIME = 2;

    // ─── CompanyEmpWage (UC10) ────────────────────────────────────────
    static class CompanyEmpWage {
        String companyName;
        int    wagePerHour;
        int    maxWorkingDays;
        int    maxWorkingHours;
        int    totalWage;
        List<Integer> dailyWages = new ArrayList<>();   // UC13

        CompanyEmpWage(String companyName, int wagePerHour,
                       int maxWorkingDays, int maxWorkingHours) {
            this.companyName     = companyName;
            this.wagePerHour     = wagePerHour;
            this.maxWorkingDays  = maxWorkingDays;
            this.maxWorkingHours = maxWorkingHours;
            this.totalWage       = 0;
        }

        void addDailyWage(int wage) {
            dailyWages.add(wage);
            totalWage += wage;
        }

        public String toString() {
            return "\nCompany         : " + companyName +
                    "\nWage Per Hour   : " + wagePerHour +
                    "\nMax Working Days: " + maxWorkingDays +
                    "\nMax Hours/Month : " + maxWorkingHours +
                    "\nTotal Wage      : " + totalWage +
                    "\nDaily Wages     : " + dailyWages;
        }
    }

    // ─── IEmpWageBuilder Interface (UC11) ─────────────────────────────
    interface IEmpWageBuilder {
        void addCompany(String companyName, int wagePerHour,
                        int maxWorkingDays, int maxWorkingHours);
        void computeWage(String companyName);
        int  getTotalWage(String companyName);           // UC14
        void displayAll();
    }

    // ─── EmpWageBuilder (UC8–UC14) ────────────────────────────────────
    static class EmpWageBuilder implements IEmpWageBuilder {

        // UC12: ArrayList instead of array
        List<CompanyEmpWage> companyList = new ArrayList<>();

        // UC10 / UC11 – Add a company
        @Override
        public void addCompany(String companyName, int wagePerHour,
                               int maxWorkingDays, int maxWorkingHours) {
            companyList.add(new CompanyEmpWage(
                    companyName, wagePerHour, maxWorkingDays, maxWorkingHours));
            System.out.println("Company '" + companyName + "' added.");
        }

        // UC6 – Check attendance using Random
        int checkAttendance() {
            return (int) (Math.random() * 3);   // 0 = Absent, 1 = Full, 2 = Part
        }

        // UC7 – Class method to get hours worked based on attendance
        int getHoursWorked(int attendance) {
            switch (attendance) {                // UC4 – Switch Case
                case IS_FULL_TIME: return FULL_DAY_HOURS;
                case IS_PART_TIME: return PART_TIME_HOURS;
                default:           return 0;
            }
        }

        // UC9 / UC10 – Compute wage for a specific company
        @Override
        public void computeWage(String companyName) {
            CompanyEmpWage company = getCompany(companyName);
            if (company == null) {
                System.out.println("Company not found: " + companyName);
                return;
            }

            // Reset before recomputing
            company.totalWage = 0;
            company.dailyWages.clear();

            int totalHours = 0;
            int totalDays  = 0;

            // UC6 – Loop till hours or days condition met
            while (totalHours < company.maxWorkingHours &&
                    totalDays  < company.maxWorkingDays) {

                int attendance  = checkAttendance();          // UC1
                int hoursWorked = getHoursWorked(attendance); // UC4
                int dailyWage   = hoursWorked * company.wagePerHour; // UC2/UC3

                company.addDailyWage(dailyWage);              // UC13
                totalHours += hoursWorked;
                totalDays++;
            }

            System.out.println("\nWage computed for: " + companyName);
            System.out.println(company);
        }

        // UC14 – Get total wage by company name
        @Override
        public int getTotalWage(String companyName) {
            CompanyEmpWage company = getCompany(companyName);
            if (company == null) {
                System.out.println("Company not found: " + companyName);
                return -1;
            }
            return company.totalWage;
        }

        // Display all companies and their wages
        @Override
        public void displayAll() {
            if (companyList.isEmpty()) {
                System.out.println("\nNo companies added yet.");
                return;
            }
            System.out.println("\n=== All Company Wages ===");
            for (CompanyEmpWage c : companyList) System.out.println(c);
        }

        // Helper – find company by name
        private CompanyEmpWage getCompany(String companyName) {
            for (CompanyEmpWage c : companyList)
                if (c.companyName.equalsIgnoreCase(companyName)) return c;
            return null;
        }
    }

    // ─── Main ─────────────────────────────────────────────────────────
    static EmpWageBuilder empWageBuilder = new EmpWageBuilder();
    static Scanner        scanner        = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to Employee Wage Computation Program ===");

        while (true) {
            System.out.println("\n======= MAIN MENU =======");
            System.out.println("1. Add Company");
            System.out.println("2. Compute Wage for a Company");
            System.out.println("3. Get Total Wage by Company");
            System.out.println("4. Display All Companies & Wages");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String input = scanner.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(input); }
            catch (NumberFormatException e) { System.out.println("Invalid input."); continue; }

            switch (choice) {
                case 1: addCompany();        break;
                case 2: computeWage();       break;
                case 3: getTotalWage();      break;
                case 4: empWageBuilder.displayAll(); break;
                case 5:
                    System.out.println("\nThank You! Goodbye.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Add a new company with custom wage settings
    static void addCompany() {
        System.out.print("\nEnter Company Name        : "); String name = scanner.nextLine().trim();
        System.out.print("Enter Wage Per Hour        : "); int wage = readInt();
        System.out.print("Enter Max Working Days     : "); int days = readInt();
        System.out.print("Enter Max Working Hours    : "); int hours = readInt();
        empWageBuilder.addCompany(name, wage, days, hours);
    }

    // Compute wage for an existing company
    static void computeWage() {
        System.out.print("\nEnter Company Name to compute wage: ");
        String name = scanner.nextLine().trim();
        empWageBuilder.computeWage(name);
    }

    // Get total wage for a company (UC14)
    static void getTotalWage() {
        System.out.print("\nEnter Company Name to get total wage: ");
        String name = scanner.nextLine().trim();
        int total = empWageBuilder.getTotalWage(name);
        if (total >= 0)
            System.out.println("Total Wage for '" + name + "' : " + total);
    }

    // Helper – safe integer input
    static int readInt() {
        while (true) {
            try { return Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}
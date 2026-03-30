import java.util.ArrayList;
import java.util.Random;

public class EmployeeWageMain {

    // Company class (inside same file)
    static class Company {
        String name;
        int wagePerHour;
        int workingDays;
        int maxHours;

        Company(String name, int wagePerHour, int workingDays, int maxHours) {
            this.name = name;
            this.wagePerHour = wagePerHour;
            this.workingDays = workingDays;
            this.maxHours = maxHours;
        }
    }

    // Method to compute wage
    public static void computeWage(Company company) {
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        Random random = new Random();

        while (totalHours < company.maxHours && totalDays < company.workingDays) {
            totalDays++;

            int attendance = random.nextInt(3); // 0=Absent, 1=Full, 2=Part

            int hours = 0;

            // Switch Case (UC3)
            switch (attendance) {
                case 1:
                    hours = 8; // Full time
                    break;
                case 2:
                    hours = 4; // Part time
                    break;
                default:
                    hours = 0; // Absent
            }

            int dailyWage = hours * company.wagePerHour;
            totalHours += hours;
            totalWage += dailyWage;

            System.out.println("Day " + totalDays +
                    " | Hours: " + hours +
                    " | Daily Wage: " + dailyWage);
        }

        System.out.println("\nCompany: " + company.name);
        System.out.println("Total Days: " + totalDays);
        System.out.println("Total Hours: " + totalHours);
        System.out.println("Total Wage: " + totalWage);
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        // Using Collection (ArrayList)
        ArrayList<Company> companies = new ArrayList<>();

        // Multiple companies (UC8)
        companies.add(new Company("TCS", 20, 20, 100));
        companies.add(new Company("Infosys", 25, 22, 110));
        companies.add(new Company("Wipro", 18, 20, 90));

        // Compute wage for each company
        for (Company c : companies) {
            computeWage(c);
        }

        System.out.println("Thank You");
    }
}
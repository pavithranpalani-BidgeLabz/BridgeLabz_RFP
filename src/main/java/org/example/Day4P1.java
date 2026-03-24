import java.util.Random;

public class Day4P1 {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int wagePerHour = 20;
        int fullDayHour = 8;
        int partTimeHour = 4;
        int totalWorkingDays = 20;
        int maxWorkingHours = 100;

        int totalEmpHours = 0;
        int totalWorkingDayCount = 0;
        int totalSalary = 0;

        Random random = new Random();

        while (totalEmpHours < maxWorkingHours && totalWorkingDayCount < totalWorkingDays) {
            totalWorkingDayCount++;

            int attendance = random.nextInt(3); // 0 = Absent, 1 = Full Time, 2 = Part Time
            int empHours = 0;

            if (attendance == 1) {
                empHours = fullDayHour;
                System.out.println("Day " + totalWorkingDayCount + ": Employee is Present Full Time");
            } else if (attendance == 2) {
                empHours = partTimeHour;
                System.out.println("Day " + totalWorkingDayCount + ": Employee is Present Part Time");
            } else {
                empHours = 0;
                System.out.println("Day " + totalWorkingDayCount + ": Employee is Absent");
            }

            if (totalEmpHours + empHours > maxWorkingHours) {
                empHours = maxWorkingHours - totalEmpHours;
            }

            int dailyWage = empHours * wagePerHour;
            totalEmpHours += empHours;
            totalSalary += dailyWage;

            System.out.println("Daily Wage: " + dailyWage);
        }

        System.out.println("----------------------------------");
        System.out.println("Total Working Days: " + totalWorkingDayCount);
        System.out.println("Total Working Hours: " + totalEmpHours);
        System.out.println("Total Salary for Month: " + totalSalary);
        System.out.println("Thank You");
    }
}
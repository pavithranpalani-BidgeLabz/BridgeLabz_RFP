package org.example;

import java.util.Random;

public class Problem1 {

    // Class variables (constants)
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int EMP_RATE_PER_HOUR = 20;
    public static final int MAX_WORKING_DAYS = 20;
    public static final int MAX_WORKING_HOURS = 100;

    // Method to calculate employee wage
    public void computeEmployeeWage() {

        int empHours;
        int totalEmpHours = 0;
        int totalWorkingDays = 0;

        Random random = new Random();

        while (totalEmpHours < MAX_WORKING_HOURS &&
                totalWorkingDays < MAX_WORKING_DAYS) {

            totalWorkingDays++;

            int empCheck = random.nextInt(3); // 0,1,2

            switch (empCheck) {
                case IS_FULL_TIME:
                    empHours = 8;
                    System.out.println("Day " + totalWorkingDays + ": Full Time Employee");
                    break;

                case IS_PART_TIME:
                    empHours = 4;
                    System.out.println("Day " + totalWorkingDays + ": Part Time Employee");
                    break;

                default:
                    empHours = 0;
                    System.out.println("Day " + totalWorkingDays + ": Employee Absent");
            }

            totalEmpHours += empHours;
            System.out.println("Worked Hours Today: " + empHours);
            System.out.println("--------------------------------");
        }

        int totalWage = totalEmpHours * EMP_RATE_PER_HOUR;

        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalEmpHours);
        System.out.println("Total Employee Wage: " + totalWage);
    }
}
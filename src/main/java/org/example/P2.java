package org.example;

import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Line Comparison Computation Program");

        // Line 1 coordinates
        System.out.println("Enter x1 for Line 1:");
        int x1 = sc.nextInt();

        System.out.println("Enter y1 for Line 1:");
        int y1 = sc.nextInt();

        System.out.println("Enter x2 for Line 1:");
        int x2 = sc.nextInt();

        System.out.println("Enter y2 for Line 1:");
        int y2 = sc.nextInt();

        // Line 2 coordinates
        System.out.println("Enter x1 for Line 2:");
        int x3 = sc.nextInt();

        System.out.println("Enter y1 for Line 2:");
        int y3 = sc.nextInt();

        System.out.println("Enter x2 for Line 2:");
        int x4 = sc.nextInt();

        System.out.println("Enter y2 for Line 2:");
        int y4 = sc.nextInt();

        // Length calculation
        double length1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double length2 = Math.sqrt(Math.pow((x4 - x3), 2) + Math.pow((y4 - y3), 2));

        System.out.println("Length of Line 1: " + length1);
        System.out.println("Length of Line 2: " + length2);

        // Equality check
        if (Double.valueOf(length1).equals(Double.valueOf(length2))) {
            System.out.println("Both lines are equal");
        }

        // Compare lines
        int result = Double.compare(length1, length2);

        if (result > 0) {
            System.out.println("Line 1 is greater than Line 2");
        } else if (result < 0) {
            System.out.println("Line 1 is less than Line 2");
        } else {
            System.out.println("Both lines are equal");
        }

        sc.close();
    }
}
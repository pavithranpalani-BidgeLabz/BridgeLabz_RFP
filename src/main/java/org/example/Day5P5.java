package org.example;

import java.util.Random;
import java.util.Scanner;

public class Day5P5 {

    // Static method to generate random coupon number
    public static int generateRandom(int n) {
        Random random = new Random();
        return random.nextInt(n);   // generates number between 0 to n-1
    }

    // Static method to process distinct coupons
    public static void couponNumbers() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of distinct coupon numbers:");
        int n = sc.nextInt();

        boolean[] isCollected = new boolean[n];
        int distinctCount = 0;
        int totalRandomNumbers = 0;

        while (distinctCount < n) {
            int coupon = generateRandom(n);
            totalRandomNumbers++;

            if (!isCollected[coupon]) {
                isCollected[coupon] = true;
                distinctCount++;
            }
        }

        System.out.println("Total random numbers needed: " + totalRandomNumbers);
    }

    public static void main(String[] args) {
        couponNumbers();
    }
}
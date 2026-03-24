package org.example;
import java.util.Scanner;

public class Day5P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = sc.nextInt();

        int sum = 0;


        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }

        if (sum == number) {
            System.out.println(number + " is a Perfect Number");
        } else {
            System.out.println(number + " is NOT a Perfect Number");
        }
    }
}
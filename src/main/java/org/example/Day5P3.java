package org.example;
import java.util.Scanner;

public class Day5P3 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number to check the prime number");
        int number=sc.nextInt();

        if (number <= 1) {
            System.out.println(number + " is NOT a Prime Number");
            return;
        }

        boolean isPrime = true;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is NOT a Prime Number");
        }
    }
}
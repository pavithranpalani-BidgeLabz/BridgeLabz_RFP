package org.example;

import java.util.Scanner;

class EmployeePayroll {
    int id;
    String name;
    double salary;

    EmployeePayroll(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

public class UC1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        EmployeePayroll emp = new EmployeePayroll(id, name, salary);

        System.out.println("\nEmployee Details");
        emp.display();

        sc.close();
    }
}
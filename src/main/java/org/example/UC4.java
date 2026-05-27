package org.example;

import java.io.FileWriter;
import java.io.IOException;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class UC4 {

    public static void main(String[] args) throws IOException {

        Employee emp1 = new Employee(101, "Ranjith", 50000);
        Employee emp2 = new Employee(102, "Kumar", 60000);

        FileWriter writer = new FileWriter("employee.txt");

        writer.write(emp1.id + " " + emp1.name + " " + emp1.salary + "\n");
        writer.write(emp2.id + " " + emp2.name + " " + emp2.salary + "\n");

        writer.close();

        System.out.println("Employee Payroll Written to File");
    }
}

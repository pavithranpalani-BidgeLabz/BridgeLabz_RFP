package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class UC6 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("employee.txt");

        List<String> lines = Files.readAllLines(path);

        double totalSalary = 0;

        System.out.println("Employee Details:\n");

        for (String line : lines) {

            System.out.println(line);

            String[] data = line.split(" ");

            double salary = Double.parseDouble(data[2]);

            totalSalary += salary;
        }

        System.out.println("\nTotal Salary: " + totalSalary);

        System.out.println("Average Salary: "
                + (totalSalary / lines.size()));
    }
}

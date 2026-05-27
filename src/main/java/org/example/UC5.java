package org.example;

import java.io.IOException;
import java.nio.file.*;

public class UC5 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("employee.txt");

        // Print File Content
        System.out.println("Employee Payroll Details:\n");

        Files.lines(path)
                .forEach(System.out::println);

        // Count Entries
        long count = Files.lines(path).count();

        System.out.println("\nNumber of Entries: " + count);
    }
}

package org.example;
import java.nio.file.*;
import java.io.IOException;

public class CountEntries {
    public static void main(String[] args) throws IOException {

        long count = Files.lines(Paths.get("employee.txt")).count();

        System.out.println("Number of Entries: " + count);
    }
}

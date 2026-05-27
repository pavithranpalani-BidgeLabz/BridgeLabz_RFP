package org.example;
import java.io.File;
import java.io.IOException;

public class UC2 {
    public static void main(String[] args) throws IOException {

        File file = new File("sample.txt");

        // Create File
        if (file.createNewFile()) {
            System.out.println("File Created");
        }

        // Check Exists
        if (file.exists()) {
            System.out.println("File Exists");
        }

        // Create Directory
        File dir = new File("MyFolder");
        if (dir.mkdir()) {
            System.out.println("Directory Created");
        }

        // List Files
        File current = new File(".");
        String[] files = current.list();

        System.out.println("\nFiles and Directories:");
        for (String f : files) {
            System.out.println(f);
        }

        // Delete File
        if (file.delete()) {
            System.out.println("\nFile Deleted");
        }

        // Check Not Exists
        if (!file.exists()) {
            System.out.println("File Does Not Exist");
        }
    }
}

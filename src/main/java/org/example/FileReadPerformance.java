package org.example;

import java.io.*;

public class FileReadPerformance {
    private static final String FILE_PATH = "D:/learning/testing.txt";

    public static void testFileReader() throws Exception {
        long start = System.nanoTime();

        FileReader fr = new FileReader(FILE_PATH);
        BufferedReader br = new BufferedReader(fr);
        while (br.read() != -1) {
        }

        br.close();
        long end = System.nanoTime();
        System.out.println("FileReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void testInputStreamReader() throws Exception {
        long start = System.nanoTime();

        InputStreamReader ir = new InputStreamReader(new BufferedInputStream(new FileInputStream(FILE_PATH)));
        while (ir.read() != -1) {

        }
        ir.close();
        long end = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        try {
            testFileReader();
            testInputStreamReader();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

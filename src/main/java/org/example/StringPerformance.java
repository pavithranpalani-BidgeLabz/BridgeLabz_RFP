package org.example;

public class StringPerformance {
    private static final int N = 1000;

    private static void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();

        for (int i = 0; i < N; i++) {
            sb.append("a");
        }

        long end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    private static void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();

        for (int i = 0; i < N; i++) {
            sb.append("a");
        }

        long end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    private static void testString() {
        String s = "";
        long start = System.nanoTime();

        for (int i = 0; i < N; i++) {
            s += "a";
        }
        long end = System.nanoTime();
        System.out.println("String Time: " + (end - start) / 1_000_000.0 + " ms");

    }

    public static void main(String[] args) {
        testString();
        testStringBuilder();
        testStringBuffer();
    }
}

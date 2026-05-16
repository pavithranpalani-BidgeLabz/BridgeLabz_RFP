package org.example;

import java.util.HashSet;
import java.util.TreeSet;

public class DataStructures {
    private static final int N = 1_000_000;
    private static final int TARGET = N - 1;

    public static void main(String[] args) {
        int[] array = new int[N];
        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            array[i] = i;
            set.add(i);
            treeSet.add(i);
        }

        long start = System.nanoTime();
        boolean foundArray = false;
        for (int num : array) {
            if (num == TARGET) {
                foundArray = true;
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("Array search time: " + (end - start) / 1000000.0 + " ms");

        start = System.nanoTime();
        boolean foundHash = set.contains(TARGET);
        end = System.nanoTime();
        System.out.println("HashSet search time: " + (end - start) / 1000000.0 + " ms");

        start = System.nanoTime();
        boolean foundTree = set.contains(TARGET);
        end = System.nanoTime();
        System.out.println("TreeSet search time: " + (end - start) / 1000000.0 + " ms");

        System.out.println();
        System.out.println("Array Found   : " + foundArray);
        System.out.println("HashSet Found : " + foundHash);
        System.out.println("TreeSet Found : " + foundTree);
    }
}

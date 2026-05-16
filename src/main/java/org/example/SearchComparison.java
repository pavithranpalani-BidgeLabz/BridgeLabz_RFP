package org.example;

import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    private static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] == target) {
                return true;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 1000;
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        int target = random.nextInt(size);

        System.out.println("Searching in dataset size: " + size);
        System.out.println("Target: " + target);

        long start1 = System.nanoTime();
        boolean foundLinear = linearSearch(array, target);
        long end1 = System.nanoTime();

        Arrays.sort(array);
        long start2 = System.nanoTime();
        boolean foundBinary = binarySearch(array, target);
        long end2 = System.nanoTime();

        System.out.println("Linear Search Found: " + foundLinear + " | Time = " + (end1 - start1) / 1000000.0 + " ms");
        System.out.println("Binary Search Found: " + foundBinary + " | Time = " + (end2 - start2) / 1000000.0 + " ms");

    }

}

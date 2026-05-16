package org.example;

public class SearchFirstNegativeNumber {
    private static int linearSearchNegativeNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 2, -8, 6, -6};

        int result = linearSearchNegativeNumber(array);
        System.out.println("First Negative number in linear search: " + result);
    }
}

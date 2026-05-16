package org.example;

public class SortStudentMarksByBubbleSort {
    private static void bubbleSorting(int size, int[] array) {
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {20, 40, 30, 10, 80, 50};
        int size = array.length;
        System.out.println("Sorting the elements using bubble: ");
        System.out.println("before sorting");
        for (int num : array) {
            System.out.print(num + " ");
        }

        bubbleSorting(size, array);
        System.out.println();
        System.out.println("after sorting");
        for (int num : array) {
            System.out.print(num + " ");
        }

    }


}

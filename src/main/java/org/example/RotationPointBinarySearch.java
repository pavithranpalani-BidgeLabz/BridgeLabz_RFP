package org.example;

public class RotationPointBinarySearch {
    private static int findRotationBinarySearch(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 1, 2, 3};

        int result = findRotationBinarySearch(array);
        System.out.println("Rotation Binary Search: " + result);

    }


}

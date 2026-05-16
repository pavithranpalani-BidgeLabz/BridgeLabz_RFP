package org.example;

public class findPeakInBinarySearch {
    private static int findPeak(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            boolean leftSide = (mid == 0) || array[mid] > array[mid - 1];
            boolean rightSide = (mid == array.length - 1) || array[mid] > array[mid + 1];

            if (leftSide && rightSide) {
                return array[mid];
            }
            if (mid > 0 && array[mid - 1] > array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 20, 4, 1, 0};
        int peak = findPeak(array);
        System.out.println("Peak Element: " + peak);
    }
}

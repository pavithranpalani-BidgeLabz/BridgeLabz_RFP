package org.example;

public class SearchTargetBinarySearch {
    private static boolean findTarget(int[][] array, int target) {
        int rows = array.length;
        int cols = array[0].length;

        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int midvalue = array[row][col];
            if (midvalue == target) {
                return true;
            } else if (target < midvalue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 6;
        boolean result = findTarget(array, target);
        System.out.println("Target found: " + result);
    }
}

package org.example;

public class FirstLastOccurrenceBinarySearch {
    public static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            }
            else if (target < arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {21, 56, 44, 95, 95, 11};
        int target = 95;

        int first = firstOccurrence(array, target);
        int last = lastOccurrence(array, target);

        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }
}

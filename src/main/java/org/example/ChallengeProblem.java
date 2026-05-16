package org.example;

import java.util.Arrays;

public class ChallengeProblem {
    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;
        boolean[] present = new boolean[n + 1];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return n + 1;
    }
    public static int binarySearch(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1, 5};
        int target = 4;

        int missing = firstMissingPositive(array);
        System.out.println("First Missing Positive Integer: " + missing);

        int index = binarySearch(array, target);
        System.out.println("Target " + target + " found at index (after sorting): " + index);
    }
}

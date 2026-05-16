package org.example;

public class CountingSortStudentAges {
    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];
        for (int age : ages) {
            count[age - minAge]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 12, 14, 10, 17};

        System.out.println("Before Sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        countingSort(ages);
        System.out.println();
        System.out.println("After Counting Sort:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}

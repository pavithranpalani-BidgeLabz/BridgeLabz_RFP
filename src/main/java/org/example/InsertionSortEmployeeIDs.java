package org.example;

public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] empIds) {
        for (int i = 1; i < empIds.length; i++) {
            int key = empIds[i];
            int j = i - 1;

            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }
            empIds[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] employeeIds = {105, 101, 110, 102, 108};

        System.out.println("Before Sorting:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }

        insertionSort(employeeIds);
        System.out.println("After Sorting:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}

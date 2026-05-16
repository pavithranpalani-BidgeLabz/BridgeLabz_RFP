package org.example;

public class HeapSortSalaries {
    public static void heapSort(int[] salary) {
        int n = salary.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(salary, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;
            heap(salary, i, 0);
        }
    }

    public static void heap(int[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heap(arr, size, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {45000, 60000, 30000, 80000, 50000};
        System.out.println("Before Sorting:");
        for (int s : salaries) {
            System.out.print(s + " ");
        }
        heapSort(salaries);
        System.out.println();
        System.out.println("After Heap Sort:");
        for (int s : salaries) {
            System.out.print(s + " ");
        }
    }
}

package org.example.sorts;

public class InsertionSort {
    public long insertionSort(int[] array, int low, int high) {
        long iterations = 0;
        for (int i = low + 1; i <= high; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= low && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                iterations++;
            }
            array[j + 1] = key;
            iterations++;
        }
        return iterations;
    }
}

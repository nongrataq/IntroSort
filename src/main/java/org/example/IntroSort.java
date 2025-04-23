package org.example;

import org.example.sorts.HeapSort;
import org.example.sorts.InsertionSort;
import org.example.sorts.QuickSort;

public class IntroSort {
    private final HeapSort heapSort;
    private final InsertionSort insertionSort;
    private final QuickSort quickSort;

    private long iterations;

    public IntroSort() {
        heapSort = new HeapSort();
        insertionSort = new InsertionSort();
        quickSort = new QuickSort();
        iterations = 0;
    }

    public void sort(int[] arr) {
        int maxDepth = (int) (2 * Math.log(arr.length) / Math.log(2));
        introSort(arr, 0, arr.length - 1, maxDepth);
    }

    private void introSort(int[] arr, int low, int high, int maxDepth) {
        int size = high - low + 1;

        // Переключение на InsertionSort для маленьких подмассивов
        if (size <= 16) {
            iterations += insertionSort.insertionSort(arr, low, high);
            return;
        }

        // Переключение на HeapSort при исчерпании глубины рекурсии
        if (maxDepth <= 0) {
            iterations += heapSort.heapSort(arr, low, high);
            return;
        }

        // Использование QuickSort
        int pivotIndex = quickSort.partition(arr, low, high);
        iterations += quickSort.getIterations();
        introSort(arr, low, pivotIndex - 1, maxDepth - 1);
        introSort(arr, pivotIndex + 1, high, maxDepth - 1);
    }

    public long getIterations() {
        return iterations;
    }
}

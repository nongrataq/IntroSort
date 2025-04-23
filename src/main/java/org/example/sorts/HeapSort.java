package org.example.sorts;

public class HeapSort {
    long iterations;
    public long heapSort(int[] arr, int low, int high) {
        iterations = 0;
        int n = high - low + 1;

        for (int i = low + n / 2 - 1; i >= low; i--) {
            heapify(arr, n, i, low);
            iterations++;
        }

        for (int i = high; i > low; i--) {
            swap(arr, low, i);
            heapify(arr, i - low, low, low);
            iterations++;
        }
        return iterations;
    }

    private void heapify(int[] arr, int n, int i, int offset) {
        iterations++;
        int largest = i;
        int l = 2 * (i - offset) + 1 + offset;
        int r = 2 * (i - offset) + 2 + offset;

        if (l < n + offset && arr[l] > arr[largest]) {
            largest = l;
            iterations++;
        }

        if (r < n + offset && arr[r] > arr[largest]) {
            largest = r;
            iterations++;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest, offset);
        }
    }

    private void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        iterations++;
    }
}
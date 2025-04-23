package org.example.sorts;

public class QuickSort {
    long iterations;

    public int partition(int[] arr, int low, int high) {
        iterations = 0;
        iterations++;
        int mid = low + (high - low) / 2;

        if (arr[mid] < arr[low]) swap(arr, low, mid);
        if (arr[high] < arr[low]) swap(arr, low, high);
        if (arr[mid] < arr[high]) swap(arr, mid, high);

        int pivot = arr[high];

        int left = low - 1;
        int right = low - 1;
        while (right < high) {
            iterations++;
            ++right;
            if (arr[right] <= pivot) {
                ++left;
                iterations++;
                if (left < right) {
                    swap(arr, left, right);
                }
            }
        }
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        iterations++;
    }

    public long getIterations() {
        return iterations;
    }
}
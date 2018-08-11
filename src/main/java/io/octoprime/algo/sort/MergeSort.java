package io.octoprime.algo.sort;

import java.util.Arrays;

/**
 *
 */
public class MergeSort implements Sort {

    private int[] auxArr;

    /**
     * @param arr
     */
    public void sort(int arr[]) {
        this.auxArr = new int[arr.length];
        merge(arr, 0, arr.length - 1);
    }

    /**
     *
     * @param arr
     * @param low
     * @param high
     */
    private void merge(int[] arr, int low, int high) {

        if (low < high) {
            int middle = low + (high - low) / 2;
            // Below step sorts the left side of the array
            merge(arr, low, middle);
            // Below step sorts the right side of the array
            merge(arr, middle + 1, high);
            // Now merge both sides
            combine(arr, low, middle, high);
        }
    }

    /**
     *
     * @param arr
     * @param low
     * @param middle
     * @param high
     */
    private void combine(int[] arr, int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            auxArr[i] = arr[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (auxArr[i] <= auxArr[j]) {
                arr[k] = auxArr[i];
                i++;
            } else {
                arr[k] = auxArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = auxArr[i];
            k++;
            i++;
        }

    }

    /**
     * Driver code for testing the main functionality of class.  Note, we are not really using the arguments.
     * @param args
     */
    public static void main(String args[]) {

        int[] arr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};

        System.out.println("before: " + Arrays.toString(arr));
        new MergeSort().sort(arr);
        System.out.println("after : " + Arrays.toString(arr));
    }
}

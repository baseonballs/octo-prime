package io.octoprime.algo.sort;

import java.util.Arrays;

/**
 *
 Merge sort
 Merge-sort-example-300px.gif
 An example of merge sort. First divide the list into the smallest unit (1 element), then compare each element
 with the adjacent list to sort and merge the two adjacent lists. Finally all the elements are sorted and merged.
 Class	Sorting algorithm
 Data structure	Array
 Worst-case performance	O(n log n)
 Best-case performance
 O(n log n) typical,

 O(n) natural variant
 Average performance	O(n log n)
 Worst-case space complexity	О(n) total with O(n) auxiliary, O(1) auxiliary with linked lists[1]
 In computer science, merge sort (also commonly spelled mergesort) is an efficient, general-purpose,
 comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the
 implementation preserves the input order of equal elements in the sorted output. Merge sort is a divide and
 conquer algorithm that was invented by John von Neumann in 1945
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

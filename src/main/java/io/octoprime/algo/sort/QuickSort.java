package io.octoprime.algo.sort;

import java.util.Arrays;

/*
Quicksort or partition-exchange sort, is a fast sorting algorithm, which is using divide and conquer algorithm. Quicksort first divides a large list into two smaller sub-lists: the low elements and the high elements. Quicksort can then recursively sort the sub-lists.

Steps to implement Quick sort:

1) Choose an element, called pivot, from the list. Generally pivot can be the middle index element.
2) Reorder the list so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
3) Recursively apply the above steps to the sub-list of elements with smaller values and separately the sub-list of elements with greater values.
 */
public class QuickSort implements Sort {

    private int length;

    /**
     * @param arr
     */
    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        qsort(arr, 0, arr.length - 1);
    }

    /**
     * Performs the quicksort alorithm using the divide and conquer partition; Break partitions into two havles using
     * a midepoint ( low + (high-low)/2 );
     * In each iteration, we will identify a number from left side which
     * is greater then the pivot value, and also we will identify a number
     * from right side which is less then the pivot value. Once the search
     * is done, then we exchange both numbers.
     *
     * @param arr
     * @param low
     * @param high
     */
    private void qsort(int[] arr, int low, int high) {

        int i = low;
        int j = high;

        int pivot = arr[low + (high - low) / 2];

        while (i <= j) {

            // scan for all elemens less then pivot;
            while (arr[i] < pivot) {
                i++;
            }
            // scan for all elements greater then pivot;
            while (arr[j] > pivot) {
                j--;
            }

            // swap ith & jth element.
            if (i <= j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;

                i++;
                j--;
            }
        }
        if (low < j)
            qsort(arr, low, j);
        if (i < high)
            qsort(arr, i, high);
    }

    /**
     * @param args
     */
    public static void main(String args[]) {

        int[] arr = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};

        System.out.println("before: " + Arrays.toString(arr));
        new QuickSort().sort(arr);
        System.out.println("after : " + Arrays.toString(arr));
    }
}

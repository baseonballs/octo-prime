package io.octoprime.algo.sort;

import java.util.Arrays;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;

/*
The Selection sort algorithm is based on the idea of finding the minimum or maximum element in an unsorted array
and then putting it in its correct position in a sorted array.

worse: 0(n^2)
best: O(n^2)
average: O(n^2)
remark: n-exchanges; quadratic in best case
*/
public class SelectionSort {

    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    private static int[] selection(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            // do swap
            int t = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = t;
        }
        return arr;
    }

    public static void main(String[] arg) {
        BubbleSort bubble = new BubbleSort();

        int[] numbers = getRandomArray(DEFAULT_SIZE, DEFAULT_RANGE);

        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Sorted array: ");
        int[] arr2 = selection(numbers);

        System.out.println(Arrays.toString(numbers));
    }

}

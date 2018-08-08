package io.octoprime.algo.sort;

import java.util.Arrays;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;

public class InsertionSort {
    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    public static void main(String[] arg) {
        InsertionSort sort = new InsertionSort();

        int[] numbers = getRandomArray(DEFAULT_SIZE, DEFAULT_RANGE);

        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Sorted array: ");
        sort.insertion(numbers);

        System.out.println(Arrays.toString(numbers));

    }

    private void insertion(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            // storing current element whose left side is checked for its correct position .
            int temp = arr[i];
            int j = i;

            // check whether the adjacent element in left side is greater or less than the current element.
            while (j > 0 && temp < arr[j - 1]) {
                // moving the left side element to one position forward.
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            // moving current element to its  correct position.
            arr[j] = temp;
        }
    }
}

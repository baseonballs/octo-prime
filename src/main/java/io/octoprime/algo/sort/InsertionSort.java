package io.octoprime.algo.sort;

import java.util.Arrays;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;

public class InsertionSort implements Sort {
    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];

            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            arr[j] = temp;
        }
    }


    public static void main(String[] arg) {
        InsertionSort insertion = new InsertionSort();

        int[] numbers = getRandomArray(DEFAULT_SIZE, DEFAULT_RANGE);

        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Sorted array: ");
        insertion.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}

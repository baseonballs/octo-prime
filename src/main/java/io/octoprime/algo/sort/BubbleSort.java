package io.octoprime.algo.sort;

import java.util.Arrays;
import static io.octoprime.algo.ds.DataStructure.getRandomArray;

/**
Sorting Algorithms are concepts that every competitive programmer must know. Sorting algorithms can be used for
collections of numbers, strings, characters, or a structure of any of these types.

Bubble sort is based on the idea of repeatedly comparing pairs of adjacent elements and then swapping their
positions if they exist in the wrong order.

Complexity: worse & average = O(N^2), best = O(n)
*/
public class BubbleSort implements Sort {

    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    public static void sort(Integer[] arr) {
        Arrays.stream(arr).sorted();
    }

    public void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
    }

    public void reverse(int[] arr) {
        int n = arr.length;

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void main(String[] arg) {
        BubbleSort bubble = new BubbleSort();

        int[] numbers = getRandomArray(DEFAULT_SIZE, DEFAULT_RANGE);

        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Sorted array: ");
        bubble.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

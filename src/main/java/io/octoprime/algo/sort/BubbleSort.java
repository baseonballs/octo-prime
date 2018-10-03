package io.octoprime.algo.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

import static io.octoprime.utils.DataStructure.getRandomArray;

/**
 * Bubble sort is based on the idea of repeatedly comparing pairs of adjacent elements and then swapping their
 * positions if they exist in the wrong order.
 * <p>
 * Complexity: worse & average = O(N^2), best = O(n)
 * worse:   O(n^2)
 * average: O(n^2)
 * best:    O(n)
 * avg
 */
public class BubbleSort implements Sort {

    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    public void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    void bubbleSortWithStreams(Integer[] arr) {
        int n = arr.length;
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(i + 1, n - i))
                .forEach(j -> {
                    if (arr[j - 1] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                });
    }

    void optimizedBubbleSort(Integer[] arr) {
        int i = 0, n = arr.length;
        boolean swapNeeded;

        while (i < (n - 1)) {
            swapNeeded = false;

            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapNeeded = true;
                }
            }
            if (!swapNeeded) {
                break;
            }
            i++;
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

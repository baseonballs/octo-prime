package io.octoprime.algo.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;

/**
 * Bubble sort is based on the idea of repeatedly comparing pairs of adjacent elements and then swapping their
 * positions if they exist in the wrong order.
 * <p>
 * Complexity: worse & average = O(N^2), best = O(n)
 */
public class BubbleSort implements Sort {

    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    public static void sort(Integer[] arr) {
        Arrays.stream(arr).sorted();
    }


    public void reverse(int[] arr) {
        int n = arr.length;

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }


    public void sort1(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
    }

    public void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    // stream vsion
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

    public void optimizedBubbleSort(Integer[] arr) {
        int i = 0, n = arr.length;
        boolean swapNeeded = true;
        while ((i < (n - 1) && swapNeeded)) {
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

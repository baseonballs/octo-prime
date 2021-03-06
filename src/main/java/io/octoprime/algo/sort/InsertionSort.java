package io.octoprime.algo.sort;

import java.util.Arrays;

import static io.octoprime.utils.DataStructure.getRandomArray;

/**
 * The insertion sort algorithm is based on the idea of cards in the hand.  Start with i+1, and scan to the left of the
 * hand and find a slot that can be inserted into the rightful place.
 * <p>
 * worse: 0(n^2)
 * best: O(n^2)
 * average: O(n^2)
 */
public class InsertionSort implements Sort {
    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    //  @Override
    public void sorti(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;

            while ((j > 0) && (temp < arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = temp;
        }
    }

    /**
     * Insertion sort based on ideas of exchange cards in hand.  Start with i+1 and find values to swap less
     * then element at j;
     *
     * @param arr
     * @return
     */
    @Override
    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
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

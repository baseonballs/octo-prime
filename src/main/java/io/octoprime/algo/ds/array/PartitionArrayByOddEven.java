package io.octoprime.algo.ds.array;


/**
 * Partition Array by Odd and Even
 * Question
 * lintcode: (373) Partition Array by Odd and Even
 * Segregate Even and Odd numbers - GeeksforGeeks
 * Partition an integers array into odd number first and even number second.
 * Example
 * Given [1, 2, 3, 4], return [1, 3, 2, 4]
 * Challenge
 * Do it in-place.
 */
public class PartitionArrayByOddEven {

    /**
     * @param arr: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] arr) {
        if (arr == null) return;
        int i = 0, j = arr.length - 1;

        while (i < j) {

            // odd number
            while (i < j && arr[i] % 2 != 0) {
                i++;
            }

            // even number
            while (i < j && arr[j] % 2 == 0) {
                j--;
            }

            // swap
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

}

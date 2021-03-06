package io.octoprime.algo.ds.array;

/**
 * Maximum subArray problem:
 * From Wikipedia :
 * In computer science, the maximum subarray problem is the task of finding the contiguous subarray within a
 * one-dimensional arr of numbers which has the largest sum. For example, for the sequence of values −2, 1, −3,
 * 4, −1, 2, 1, −5, 4; the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
 * <p>
 * Kadane ‘s Algorithm can be used to solve maximum sub arr problem
 * <p>
 * Kadane’s algorithm:
 * Initialize maxSoFar= 0 and maxEndingHere = 0
 * Iterate over each element of the arr
 * maxEndingHere = maxEndingHere + a[i]
 * if(maxEndingHere < 0)
 * maxEndingHere = 0
 * if(maxSoFar < maxEndingHere)
 * maxSoFar = maxEndingHere
 * <p>
 * return maxSoFar
 */

import java.util.Arrays;

/**
 * http://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
 * http://www.techiedelight.com/print-continuous-subarray-with-maximum-sum/
 */
public class MaximumSubArray {


    /* Kadane algorithm
     * It won't work when all elements of arr are negative
     */
    public static int maximumSubArrayNoAllNeg(int[] arr) {

        int maxcur = 0;
        int maxseq = 0;

        for (int i = 0; i < arr.length; i++) {

            maxcur = Math.max(maxcur + arr[i], 0);
            maxseq = Math.max(maxseq, maxcur);
        }

        return maxseq;
    }

    /* Modified Kadane's algorithm
     * If you make small modification to above algorithm
     * It will work for negative numbers too
     */
    public static int maximumSubArray(int[] arr) {

        int maxcur = arr[0];
        int maxseq = arr[0];

        for (int i = 1; i < arr.length; i++) {

            /**
             * max sum should be more than the current element.
             */
            maxcur = Math.max(maxcur + arr[i], arr[i]);

            /**
             * update the result if current sub-array sum is found to be greater.
             */
            maxseq = Math.max(maxseq, maxcur);
        }

        return maxseq;
    }

    public static int kadaneNaive(int[] A) {

        int max = Arrays.stream(A).max().getAsInt();

        // if array contains al negative values, return maximum element.
        if (max < 0)
            return max;

        int maxSoFar = 0, maxEndingHere = 0;

        int start = 0, end = 0, beg = 0;

        int j = 0;
        for (int elem : A) {

            maxEndingHere = Math.max(maxEndingHere + elem, 0);
            if (maxEndingHere == 0) beg = j + 1;

            if (maxSoFar < maxEndingHere) {
                start = beg;
                end = j;
            }
            maxSoFar = Math.max(maxSoFar, maxEndingHere);

            j++;
        }

        System.out.println("The sum of contiguous sub-array with the " + "largest sum is " + maxSoFar);
        System.out.println("start: " + start + ", end =  " + end);

        System.out.print("{");
        for (int i = start; i <= end; i++) {
            System.out.print(A[i] + (i == end ? "" : ", "));
        }
        System.out.println("}");

        return maxSoFar;
    }

    public static void main(String args[]) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubArray maxSum = new MaximumSubArray();

        System.out.println("Maximum subarray is  " + maximumSubArray(arr));
        int arrNeg[] = {-10, -8, -3, -7, -2, -7, -3, -9};
        System.out.println("Maximum Subarray when all elements are negative : " +
                maximumSubArray(arrNeg));
    }

}

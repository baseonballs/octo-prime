package io.octoprime.algo.ds.array;

/*


Maximum subArray problem:
From Wikipedia :
In computer science, the maximum subarray problem is the task of finding the contiguous subarray within a one-dimensional arr of numbers which has the largest sum. For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

Kadane ‘s Algorithm can be used to solve maximum sub arr problem

Kadane’s algorithm:
Initialize maxSoFar= 0 and maxEndingHere = 0
Iterate over each element of the arr
maxEndingHere = maxEndingHere + a[i]
if(maxEndingHere < 0)
 maxEndingHere = 0
if(maxSoFar < maxEndingHere)
 maxSoFar = maxEndingHere
return maxSoFar


 */
public class MaximumSubArray {


    /* Kadane algorithm
     * It won't work when all elements of arr are negative
     */
    public int kandaneForMaxSubArray(int[] arr) {
        int maxEndHere = 0;
        int maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEndHere += arr[i];
            if (maxEndHere < 0) {
                maxEndHere = 0;
            }
            if (maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
            }
        }
        return maxSoFar;
    }

    /* Modified Kadane's algorithm
     * If you make small modification to above algorithm
     * It will work for negative numbers too
     */
    public int kandaneForMaxSubArrayForNegativ(int[] arr) {
        int maxEndHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndHere = Math.max(arr[i], maxEndHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }

    public static void main(String args[]) {
        int arr[] = {1, 8, -3, -7, 2, 7, -1, 9};
        MaximumSubArray maxSum = new MaximumSubArray();
        System.out.println("Maximum subarray is  " + maxSum.kandaneForMaxSubArray(arr));
        int arrNeg[] = {-10, -8, -3, -7, -2, -7, -3, -9};
        System.out.println("Maximum Subarray when all elements are negative : " + maxSum.kandaneForMaxSubArrayForNegativ(arrNeg));
    }

}

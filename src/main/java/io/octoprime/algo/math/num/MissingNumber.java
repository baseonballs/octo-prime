package io.octoprime.algo.math.num;

/**
 * Problem
 * Given an array contains N numbers of 0 .. N , find which number doesn't exist
 * in the array.
 * Example
 * Given N = 3 and the array [0, 1, 3] , return 2.
 * Challenge
 * Do it in-place with O(1) extra memory and O(n) time.
 */
public class MissingNumber {

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        result ^= nums.length;
        return result;
    }
}

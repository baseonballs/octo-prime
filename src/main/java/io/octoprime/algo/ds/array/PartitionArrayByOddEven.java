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
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null) return;
        int left = 0, right = nums.length - 1;

        while (left < right) {

            // odd number
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }

            // even number
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

            // swap
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

}

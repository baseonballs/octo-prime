package io.octoprime.algo.ds.array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 * <p>
 * Analysis:
 * <p>
 * This is similar to maximum subarray. Instead of sum, the sign of number affect the product value.
 * <p>
 * When iterating the array, each element has two possibilities: positive number or negative number. We need to
 * track a minimum value, so that when a negative number is given, it can also find the maximum value.
 * We define two local variables, one tracks the maximum and the other tracks the minimum.
 * <p>
 * Running Time: O(n)
 */
public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }

}

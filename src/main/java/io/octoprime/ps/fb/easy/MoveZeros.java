package io.octoprime.ps.fb.easy;

import java.util.Arrays;
import java.util.Vector;

public class MoveZeros {
    /**
     * space complexity: O(n)
     * time complexity: O(n); however it is sub optimal due to additional steps required.
     * sub-optimal
     *
     * @param nums
     * @return
     */
    private static int[] moveZeroSpaceSubOptimal(int[] nums) {
        int n = nums.length;

        // Count the zeroes
        int numZeroes = 0;
        for (int i = 0; i < n; i++) {
            numZeroes += (nums[i] == 0) ? 1 : 0;
        }

        // Make all the non-zero elements retain their original order.
        Vector ans = new Vector<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                ans.add(nums[i]);
            }
        }

        // Move all zeroes to the end
        while (numZeroes-- != 0) {

            ans.add(0);
        }

        // Combine the result
        for (int i = 0; i < n; i++) {

            nums[i] = (int) ans.get(i);
        }
        return nums;
    }

    /**
     * space complexity: O(n)
     * time complexity: O(n); however it is sub optimal due to additional steps required.
     * approach #2
     *
     * @param nums
     * @return
     */
    private static int[] moveZeroSpaceOptimalOpsSubtimal(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    /**
     * @param nums
     * @return
     */
    private static int[] moveZeroOptimal(int[] nums) {

        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int t = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = t;
            }
        }

        return nums;
    }

    /**
     * @param nums
     * @return
     */
    private static int[] moveZerosOptimizal2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count++;
            if (count != 0 && nums[i] != 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
        return nums;
    }

    public static void main(String[] arg) {

        //    int[] arr0 = {0, 1, 0};
        int[] arr0 = {0, 1, 0, 3, 12};

        System.out.println("pre array: " + Arrays.toString(arr0));


        System.out.println(Arrays.toString(moveZeroSpaceOptimalOpsSubtimal(arr0)));
    }
}

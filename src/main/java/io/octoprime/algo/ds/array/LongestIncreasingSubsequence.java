package io.octoprime.algo.ds.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example, given [10, 9, 2, 5, 3, 7, 101, 18], the longest increasing subsequence is
 * [2, 3, 7, 101]. Therefore the length is 4.
 */
public class LongestIncreasingSubsequence {

    /**
     * Let max[i] represent the length of the longest increasing subsequence so far.
     * If any element before i is smaller than nums[i], then max[i] = max(max[i], max[j]+1).
     * Here is an example:
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] max = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            max[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < max.length; i++) {
            if (max[i] > result)
                result = max[i];
        }
        return result;
    }

    public int lengthOfLISSimplification(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);

                }
            }
            result = Math.max(max[i], result);
        }

        return result;
    }


    /**
     * Implementation 2 - BSearch
     * <p>
     * We can put the increasing sequence in a list.
     * <p>
     * for each num in nums
     * if(list.size()==0)
     * add num to list
     * else if(num > last element in list)
     * add num to list
     * else
     * replace the element in the list which is the smallest but bigger than num
     */

    public int lengthOfLISBSearch(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int num : nums) {
            if (list.size() == 0 || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (list.get(mid) < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                list.set(j, num);
            }
        }

        return list.size();
    }
}

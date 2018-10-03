package io.octoprime.algo.ds.array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Analysis:
 * <p>
 * This problem is a binary search and the key is breaking the array to two parts, so that we only need to
 * work on half of the array each time.
 * <p>
 * If we pick the middle element, we can compare the middle element with the leftmost (or rightmost) element.
 * If the middle element is less than leftmost, the left half should be selected; if the middle element is greater
 * than the leftmost (or rightmost), the right half should be selected. Using recursion or iteration, this
 * problem can be solved in time log(n).
 * <p>
 * In addition, in any rotated sorted array, the rightmost element should be less than the left-most element,
 * otherwise, the sorted array is not rotated and we can simply pick the leftmost element as the minimum.
 */
public class FindMinInRoratedSortedArray {

    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public int findMin(int[] num, int left, int right) {
        if (left == right)
            return num[left];
        if ((right - left) == 1)
            return Math.min(num[left], num[right]);

        int middle = left + (right - left) / 2;

        // not rotated
        if (num[left] < num[right]) {
            return num[left];

            // go right side
        } else if (num[middle] > num[left]) {
            return findMin(num, middle, right);

            // go left side
        } else {
            return findMin(num, left, middle);
        }
    }


    public int findMiIetration(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length - 1;

        //not rotated
        if (nums[left] < nums[right])
            return nums[left];

        while (left <= right) {
            if (right - left == 1) {
                return nums[right];
            }

            int m = left + (right - left) / 2;

            if (nums[m] > nums[right])
                left = m;
            else
                right = m;
        }

        return nums[left];
    }


    /*

     */

    /**
     * To understand the boundaries, use the following 3 examples:
     * [2,1], [2,3,1], [3,1,2]
     *
     * @param nums
     * @return
     */
    public int findMininumInRotatedSortedArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] <= nums[j])
                return nums[i];

            int m = (i + j) / 2;

            if (nums[m] >= nums[i]) {
                i = m + 1;
            } else {
                j = m;
            }
        }

        return -1;
    }

}

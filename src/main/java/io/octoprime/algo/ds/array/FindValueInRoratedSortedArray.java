package io.octoprime.algo.ds.array;


/**
 * Java program to search an element in
 * sorted and rotated array using
 * single pass of Binary Search
 */
public class FindValueInRoratedSortedArray {


    /**
     * Iterative version of search in sorted, rotated array.
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }

        return false;
    }


    /**
     * Returns index of key in arr[l..h]
     * // if key is present, otherwise returns -1
     *
     * @param arr
     * @param low
     * @param high
     * @param value
     * @return
     */
    static int search(int arr[], int low, int high, int value) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == value)
            return mid;

        /* If arr[l...mid] is sorted */
        if (arr[low] <= arr[mid]) {
            /**
             * As this subarray is sorted, we
             *                can quickly check if key lies in
             *                half or other half
             */
            if (value >= arr[low] && value <= arr[mid])
                return search(arr, low, mid - 1, value);

            return search(arr, mid + 1, high, value);
        }

        /**
         * If arr[l..mid] is not sorted,
         *            then arr[mid... r] must be sorted
         */
        if (value >= arr[mid] && value <= arr[high])
            return search(arr, mid + 1, high, value);

        return search(arr, low, mid - 1, value);
    }

    //main function
    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 6;
        int i = search(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}

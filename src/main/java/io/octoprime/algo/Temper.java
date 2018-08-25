package io.octoprime.algo;

import io.octoprime.utils.AbstractUtils;

import java.util.Arrays;


public class Temper extends AbstractUtils {

    private static void insertion(int[] arr, int low, int high) {

        int i = low;
        int j = high;

        int pivot = arr[i + (j - i) / 2];
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }

        if (low < j) insertion(arr, low, j);
        if (i < high) insertion(arr, i, high);
    }

    private static void doTask() {
        int[] arr0 = {33, 2, 13, 98, 7, 5, 28, 19};
        int[] arr1 = randomizeArray(10);
        int[] arr2 = randomizeArray(10);

        System.out.println("before: " + Arrays.toString(arr0));
        insertion(arr0, 0, arr0.length - 1);
        System.out.println("after: " + Arrays.toString(arr0));
    }


    private static void doTask1(int[] nums) {
        // {0, 1, 0, 3,12};

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count++;
            if (count != 0 && nums[i] != 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] arg) {

        int[] arr0 = {0, 1, 0, 3, 12};

        doTask1(arr0);
    }
}

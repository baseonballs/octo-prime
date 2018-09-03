package io.octoprime.algo.ds.array;

import io.octoprime.utils.UtilsArray;

import java.util.Arrays;

public class ZSandbox {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int m = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[m]) m = j;
            }

            int t = arr[m];
            arr[m] = arr[i];
            arr[i] = t;
        }
    }


    int bsearch(int[] arr, int low, int high, int value) {

        if (low <= high) {
            int pivot = low + (high - low) / 2;

            if (value == arr[pivot]) return pivot;
            if (value < arr[pivot]) return bsearch(arr, low, pivot - 1, value);
            if (value > arr[pivot]) return bsearch(arr, pivot + 1, high, value);
        }

        return -1;
    }


    public static void main(String[] args) {

        int[] arrs = new int[]{39, 2, 18, 9, 1, 11, 99, 21, 15, 88};
        int[] arr = new UtilsArray().randomArrayAsInt(10, 100);

        System.out.println(Arrays.toString(arrs));
        sort(arrs);
        System.out.println(Arrays.toString(arrs));

        int bIndex = new ZSandbox().bsearch(arrs, 0, arrs.length - 1, 2);

        System.out.println("index : " + bIndex);
        if (bIndex == -1)
            System.out.println("not found.");
        else
            System.out.println("Element found.");

    }
}

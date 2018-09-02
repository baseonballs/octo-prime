package io.octoprime.algo.ds.array;

import io.octoprime.utils.UtilsArray;

import java.util.Arrays;

public class ZSandbox {


    public static void bsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }


    public static void isort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int m = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[m]) m = j;
            }

            int t = arr[m];
            arr[m] = arr[i];
            arr[i] = t;
        }
    }

    public static void ssort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
    }


    public int bsearch(int[] arr, int low, int high, int key) {
        if (low <= high) {
            int pivot = low + (high - low) / 2;

            if (key == arr[pivot]) return pivot;

            if (low < arr[pivot]) return bsearch(arr, low, pivot - 1, key);
            else if (low > arr[pivot]) return bsearch(arr, pivot + 1, high, key);
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arrs = new int[]{39, 2, 18, 9, 1, 11, 99, 21, 15, 88};
        int[] arr = new UtilsArray().randomArrayAsInt(10, 100);

        System.out.println(Arrays.toString(arrs));
        ssort(arrs);
        System.out.println(Arrays.toString(arrs));

        int bIndex = new ZSandbox().bsearch(arrs, 0, arrs.length - 1, 2);

        System.out.println("index : " + bIndex);
        if (bIndex == -1)
            System.out.println("not found.");
        else
            System.out.println("Element found.");

    }
}

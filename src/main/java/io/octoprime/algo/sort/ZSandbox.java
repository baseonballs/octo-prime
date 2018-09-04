package io.octoprime.algo.sort;

import io.octoprime.utils.UtilsArray;

import java.util.Arrays;

public class ZSandbox {


    public static void qsort(int[] arr, int low, int high) {

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

        if (low < j) qsort(arr, low, j);
        if (i < high) qsort(arr, i, high);
    }

    public static void bsort(int[] arr, int low, int high) {
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

    public static void isort(int[] arr, int low, int high) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void ssort(int[] arr, int low, int high) {

        for (int i = 0; i < arr.length; i++) {
            // scan for min index
            int m = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[m])
                    m = j;
            }
            // swap mindex, i
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
        ssort(arrs, 0, arr.length - 1);
        System.out.println(Arrays.toString(arrs));

        int bIndex = new ZSandbox().bsearch(arrs, 0, arrs.length - 1, 2);

        System.out.println("index : " + bIndex);
        if (bIndex == -1)
            System.out.println("not found.");
        else
            System.out.println("Element found.");

    }
}

package io.octoprime.algo;

import io.octoprime.AbstractUtils;

import java.util.Arrays;


public class Temper extends AbstractUtils {

    private static void insertion(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = temp;
        }

    }

    private static void doTask() {
        int[] arr0 = {33, 2, 13, 98, 7, 5, 28, 19};
        int[] arr1 = randomizeArray(10);
        int[] arr2 = randomizeArray(10);

        System.out.println("before: " + Arrays.toString(arr0));
        insertion(arr0);
        System.out.println("after: " + Arrays.toString(arr0));
    }

    public static void main(String[] arg) {
        doTask();
    }
}

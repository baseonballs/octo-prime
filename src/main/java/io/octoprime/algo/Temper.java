package io.octoprime.algo;

import io.octoprime.AbstractUtils;

import java.util.Arrays;


public class Temper extends AbstractUtils {

    static void bubble(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void main(String[] arg) {
        int[] arr0 = {33, 2, 13, 98, 7, 5, 28, 19};
        int[] arr1 = randomizeArray(10);
        int[] arr2 = randomizeArray(10);

        System.out.println("before: " + Arrays.toString(arr0));
        bubble(arr0);
        System.out.println("after: " + Arrays.toString(arr0));


    }
}

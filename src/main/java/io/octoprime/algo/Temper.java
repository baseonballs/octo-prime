package io.octoprime.algo;

import io.octoprime.AbstractUtils;

import java.util.Arrays;


public class Temper extends AbstractUtils {


    private static void insertion(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            // storing current element whose left side is checked for its correct position .
            int temp = arr[i];
            int j = i;

            // check whether the adjacent element in left side is greater or less than the current element.
            while (j > 0 && temp < arr[j - 1]) {
                // moving the left side element to one position forward.
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            // moving current element to its  correct position.
            arr[j] = temp;
        }
    }

    public static void main(String[] arg) {

        int[] arr = randomizeArray(10);

        System.out.println(Arrays.toString((arr)));

        insertion(arr);

        System.out.println(Arrays.toString((arr)));


    }
}

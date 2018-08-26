package io.octoprime.algo.math.num;

import java.util.Arrays;

public class SumOfTwoNumbersTarget {


    public static int[] sumAddingToTarget(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == target) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] arg) {

        int[] arr = new int[]{2, 3, 7, 8, 0};

        System.out.println(Arrays.toString(sumAddingToTarget(arr, 11)));
    }
}

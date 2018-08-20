package io.octoprime.algo;

import io.octoprime.AbstractUtils;

import java.util.Arrays;
import java.util.stream.IntStream;


public class Temper extends AbstractUtils {

    private static void bubble(int[] arr) {

        IntStream.range(0, arr.length - 1)
                .flatMap(i -> IntStream.range(i + 1, arr.length - i))
                .forEach(j ->
                {
                    if (arr[j - 1] > arr[j]) {
                        int t = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = t;
                    }
                });
    }

    private static void doTask() {
        int[] arr0 = {33, 2, 13, 98, 7, 5, 28, 19};
        int[] arr1 = randomizeArray(10);
        int[] arr2 = randomizeArray(10);

        System.out.println("before: " + Arrays.toString(arr0));
        bubble(arr0);
        System.out.println("after: " + Arrays.toString(arr0));
    }

    public static void main(String[] arg) {
        doTask();
    }
}

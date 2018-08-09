package io.octoprime.algo;

import java.util.Arrays;
import java.util.Random;


public class Temper {


    private static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j - 1] < arr[j]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void main(String[] arg) {

        Random r = new Random();

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(100);

        System.out.println(Arrays.toString(arr));
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
}

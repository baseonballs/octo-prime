package io.octoprime.algo;

import java.util.Arrays;
import java.util.Random;



public class Temper {

    private static int partition(int[] arr, int start, int end) {
        int i = start + 1;
        int pivot = arr[start];

        for (int j = start + 1; j < end; j++) {
            if (pivot > arr[j]) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
            }
        }
        int t = arr[start];
        arr[start] = arr[i - 1];
        arr[i - 1] = t;

        return i - 1;
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            sort(arr, start, pivot - 1);
            sort(arr, pivot + 1, end);
        }

    }

    private static void quicksort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] arg) {

        Random r = new Random();

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(100);

        System.out.println(Arrays.toString(arr));
        quicksort(arr);
        System.out.println(Arrays.toString(arr));

        String s = "Hello World.";

        char[] ch = s.toCharArray();
        char[] charr = new char[ch.length];

        System.out.println(Arrays.toString(ch));

        for (int i = 0; i < ch.length; i++) {
            charr[(i + 2) % ch.length] = ch[i];
        }

        System.out.println(Arrays.toString(charr));

        for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
            char t = ch[i];
            ch[i] = ch[j];
            ch[j] = t;
        }

        System.out.println(new String(ch));
    }
}

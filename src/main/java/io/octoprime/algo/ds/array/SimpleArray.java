package io.octoprime.algo.ds.array;


import java.util.Arrays;

public class SimpleArray {

    static int sum(int arr[], int n) {
        if (n <= 0)
            return 0;
        return (sum(arr, n - 1) + arr[n - 1]);
    }

    // Create an array with all unique elements
    public static int[] removeDuplicates(int[] arr) {
        if (arr.length < 2)
            return arr;

        int j = 0;
        int i = 1;

        while (i < arr.length) {
            if (arr[i] == arr[j]) {
                i++;
            } else {
                j++;
                arr[j] = arr[i];
                i++;
            }
        }

        int[] B = Arrays.copyOf(arr, j + 1);

        return B;
    }

    public static int countUnique(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            }
        }
        return (arr.length - count);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};

        System.out.println("sum: " + sum(arr, arr.length - 1));

        int[] dups = {1, 2, 2, 3, 3};
        dups =

                removeDuplicates(dups);
        System.out.println(dups.length);
    }
}

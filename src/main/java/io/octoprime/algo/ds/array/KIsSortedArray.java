package io.octoprime.algo.ds.array;


import java.util.Arrays;

public class KIsSortedArray {


    // Method to check whether the given array is
    // a 'k' sorted array or not
    static boolean isKSortedArray(int arr[], int n, int k) {
        // auxiliary array 'aux'
        int aux[] = new int[n];

        // copy elements of 'arr' to 'aux'
        for (int i = 0; i < n; i++)
            aux[i] = arr[i];

        // sort 'aux'
        Arrays.sort(aux);

        // for every element of 'arr' at currIndex 'i',
        // find its currIndex 'j' in 'aux'
        for (int i = 0; i < n; i++) {
            // currIndex of arr[i] in sorted array 'aux'
            int j = Arrays.binarySearch(aux, arr[i]);

            // if abs(i-j) > k, then that element is
            // not at-most k distance away from its
            // target position. Thus,  'arr' is not a
            // k sorted array
            if (Math.abs(i - j) > k)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8};

        System.out.println("a array: " + Arrays.toString(a));
        System.out.println("b array: " + Arrays.toString(b));
    }
}

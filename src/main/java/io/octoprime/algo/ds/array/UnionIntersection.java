package io.octoprime.algo.ds.array;

import java.util.Arrays;

/**
 *
 */
public class UnionIntersection {

    private static BinarySearchArray _bs = new BinarySearchArray();

    /**
     * Prints union of arr1[0..m-1] and arr2[0..n-1]
     *
     * @param arr1
     * @param arr2
     * @param m
     * @param n
     */
    void union(int arr1[], int arr2[], int m, int n) {

        // Before finding union, make sure arr1[0..m-1]
        // is smaller
        if (m > n) {
            int tempp[] = arr1;
            arr1 = arr2;
            arr2 = tempp;

            int temp = m;
            m = n;
            n = temp;
        }

        // Now arr1[] is smaller
        // Sort the first array and print its elements (these two
        // steps can be swapped as order in output is not important)
        Arrays.sort(arr1);
        for (int i = 0; i < m; i++)
            System.out.print(arr1[i] + " ");

        // Search every element of bigger array in smaller array
        // and print the element if not found
        for (int i = 0; i < n; i++) {
            if (_bs.bsearch(arr1, 0, m - 1, arr2[i]) == -1)
                System.out.print(arr2[i] + " ");
        }
    }

    /**
     * Prints intersection of arr1[0..m-1] and arr2[0..n-1]
     *
     * @param arr1
     * @param arr2
     * @param m
     * @param n
     */
    void intersection(int arr1[], int arr2[], int m, int n) {
        // Before finding intersection, make sure arr1[0..m-1]
        // is smaller
        if (m > n) {
            int tempp[] = arr1;
            arr1 = arr2;
            arr2 = tempp;

            int temp = m;
            m = n;
            n = temp;
        }

        // Now arr1[] is smaller
        // Sort smaller array arr1[0..m-1]
        Arrays.sort(arr1);

        // Search every element of bigger array in smaller array
        // and print the element if found
        for (int i = 0; i < n; i++) {
            if (_bs.bsearch(arr1, 0, m - 1, arr2[i]) != -1)
                System.out.print(arr2[i] + " ");
        }
    }

    /**
     * Driver program to test above functions
     * @param args
     */
    public static void main(String[] args) {
        UnionIntersection ui = new UnionIntersection();
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};

        System.out.println("Array-1: " + Arrays.toString((arr1)));
        System.out.println("Array-2: " + Arrays.toString((arr2)));
        System.out.println();

        /*
         * union of two arrays
         */
        System.out.println("Union of two arrays is ");
        ui.union(arr1, arr2, arr1.length, arr2.length);
        System.out.println();

        /*
         * intersection of two arrays.
         */
        System.out.println("Intersection of two arrays is ");
        ui.intersection(arr1, arr2, arr1.length, arr2.length);
    }
}

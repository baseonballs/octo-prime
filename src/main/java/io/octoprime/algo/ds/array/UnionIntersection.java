package io.octoprime.algo.ds.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Utility class for generation union and intersection of two arrays.
 */
public class UnionIntersection {

    private static BinarySearchArray _bs = new BinarySearchArray();

    /**
     * Prints union of arr1[0..m-1] and arr2[0..n-1]
     *
     * @param arr1 first array
     * @param arr2 second array
     */
    int[] union(int arr1[], int arr2[]) {

        LinkedList<Integer> list = new LinkedList<>();

        int m = arr1.length;
        int n = arr2.length;

        /*
         * Before finding union, make sure arr1[0..m-1] is smaller
         */
        if (m > n) {
            int tempp[] = arr1;
            arr1 = arr2;
            arr2 = tempp;

            int temp = m;
            m = n;
            n = temp;
        }

        /**
         *  Now arr1[] is smaller Sort the first array and print its elements (these two
         *  steps can be swapped as order in output is not important)
         */
        Arrays.sort(arr1);
        for (int i = 0; i < m; i++)
            list.add(arr1[i]);

        /**
         * Search every element of bigger array in smaller array and add the element if not found
         */
        for (int i = 0; i < n; i++) {
            if (_bs.bsearch(arr1, 0, m - 1, arr2[i]) == -1)
                list.add(arr2[i]);
        }

        return list.stream().mapToInt(e -> e).toArray();
    }

    /**
     * Prints intersection of arr1[0..m-1] and arr2[0..n-1]
     *
     * @param arr1 first array
     * @param arr2 second array
     */
    int[] intersection(int arr1[], int arr2[]) {
        // Before finding intersection, make sure arr1[0..m-1]
        // is smaller
        int m = arr1.length;
        int n = arr2.length;

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
        LinkedList<Integer> list = new LinkedList();

        for (int i = 0; i < n; i++) {
            if (_bs.bsearch(arr1, 0, m - 1, arr2[i]) != -1)
                list.add(arr2[i]);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Driver program to test above functions
     *
     * @param args standard arguments for CLI
     */
    public static void main(String[] args) {
        UnionIntersection ui = new UnionIntersection();
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};
        int[] list;

        System.out.println("Array-1: " + Arrays.toString((arr1)));
        System.out.println("Array-2: " + Arrays.toString((arr2)));
        System.out.println();

        /*
         * union of two arrays
         */
        System.out.print("Union of two arrays is: ");
        list = ui.union(arr1, arr2);
        System.out.println(Arrays.toString(list));

        /*
         * intersection of two arrays.
         */
        list = ui.intersection(arr1, arr2);
        System.out.print("Intersection of two arrays is: ");
        System.out.println(Arrays.toString(list));
    }
}

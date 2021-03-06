package io.octoprime.algo.ds.array;

import java.util.Arrays;

import static io.octoprime.utils.UtilsArray.randomArrayAsInt;

public class MergeTwoSortedArrays {

    public static void naiveMergeSortedArray(int a[], int b[]) {
        int[] merged = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;
        while (i < a.length)
            merged[k++] = a[i++];

        while (j < b.length)
            merged[k++] = b[j++];

        Arrays.sort(merged);
    }

    /**
     * run time O(n), aux space O(m+n);
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] mergeSortedArrays(int a[], int b[]) {
        int[] merged = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j])
                merged[k++] = a[i++];
            else
                merged[k++] = b[j++];
        }

        /*
        // Merging remaining  elements of a[] (if any)
        */
        while (i < a.length)
            merged[k++] = a[i++];

        /*
        // Merging remaining elements of b[] (if any)
        */
        while (j < b.length)
            merged[k++] = b[j++];

        return merged;
    }


    public static void main(String[] args) {
        int[] a = randomArrayAsInt(10, 100);
        int[] b = randomArrayAsInt(4, 10);

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println("a array: " + Arrays.toString(a));
        System.out.println("b array: " + Arrays.toString(b));

        System.out.println("sorted merged array: " + Arrays.toString(mergeSortedArrays(a, b)));
    }
}

package io.octoprime.algo.ds.array;


import java.util.Arrays;

public class SortedArray {

    public static void naiveMergeSortedArray(int a[], int b[]) {
        int[] res = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;
        while (i < a.length) {
            res[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            res[k] = b[j];
            j++;
            k++;
        }

        Arrays.sort(res);
    }

    public static int[] mergeSortedArrays(int a[], int b[]) {
        int[] res = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;
        while (i < b.length && j < a.length) {
            if (a[i] <= b[j]) {
                res[k] = a[i];
                i += 1;
                k += 1;
            } else {
                res[k] = b[j];
                j += 1;
                k += 1;
            }
        }

        while (i < a.length) {  // Merging remaining
            // elements of a[] (if any)
            res[k] = a[i];
            i += 1;
            k += 1;
        }
        while (j < b.length) {   // Merging remaining
            // elements of b[] (if any)
            res[k] = b[j];
            j += 1;
            k += 1;
        }

        return res;
    }


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

        // for every element of 'arr' at index 'i',
        // find its index 'j' in 'aux'
        for (int i = 0; i < n; i++) {
            // index of arr[i] in sorted array 'aux'
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

        System.out.println("first array: " + Arrays.toString(a));
        System.out.println("first array: " + Arrays.toString(b));

        int[] res = mergeSortedArrays(a, b);

        System.out.println("sorted merged array: " + Arrays.toString(res));
    }
}

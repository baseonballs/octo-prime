package io.octoprime.algo.ds.array;


import java.util.Arrays;

public class SimplyArray {

    static int sum(int A[], int n) {
        if (n <= 0)
            return 0;
        return (sum(A, n - 1) + A[n - 1]);
    }

    // Create an array with all unique elements
    public static int[] removeDuplicates(int[] A) {
        if (A.length < 2)
            return A;

        int j = 0;
        int i = 1;

        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }

        int[] B = Arrays.copyOf(A, j + 1);

        return B;
    }

    public static int countUnique(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                count++;
            }
        }
        return (A.length - count);
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

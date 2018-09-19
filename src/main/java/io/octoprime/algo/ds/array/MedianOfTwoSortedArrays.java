package io.octoprime.algo.ds.array;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    private double findMedianSortedArray(int[] a, int[] b) {

        if (a.length > b.length) {
            return findMedianSortedArray(b, a);
        }

        int m = a.length;
        int n = b.length;

        int low = 0;
        int high = m;

        while (low <= high) {
            int pivot1 = (low + high) / 2;
            int pivot2 = (m + n + 1) / 2 - pivot1;

            int maxL1 = pivot1 == 0 ? Integer.MIN_VALUE : a[pivot1 - 1];
            int minR1 = pivot1 == m ? Integer.MAX_VALUE : a[pivot1];

            int maxL2 = pivot2 == 0 ? Integer.MIN_VALUE : b[pivot2 - 1];
            int minR2 = pivot2 == 0 ? Integer.MAX_VALUE : b[pivot2];

            if (maxL1 <= minR2 && maxL2 <= minR1) {
                if (((m + n) % 2) == 0) {
                    return ((double) Math.max(maxL2, maxL1) + Math.min(minR1, minR2)) / 2;
                } else return (double) Math.max(maxL1, maxL2);
            } else if (maxL1 > minR2) high = pivot1 - 1;
            else low = pivot1 + 1;

        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 8, 9, 15};
        int[] arr2 = {7, 11, 19, 21, 18, 25};

        System.out.println(Arrays.toString(arr1) + " : size = " + arr1.length);
        System.out.println(Arrays.toString(arr2) + " : size = " + arr2.length);

        double val = (new MedianOfTwoSortedArrays()).findMedianSortedArray(arr1, arr2);
        System.out.println(String.format("The mediam of two sorted arr with varying length is: %1$,.2f", val));
    }
}

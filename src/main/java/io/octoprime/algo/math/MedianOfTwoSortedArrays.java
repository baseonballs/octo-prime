package io.octoprime.algo.math;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {


    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        System.out.println(Arrays.toString(x) + " : " + x.length);
        System.out.println(Arrays.toString(y) + " : " + y.length);

        double val = (new MedianOfTwoSortedArrays()).findMedianSortedArray(x, y);
        System.out.println(String.format("The mediam of two sorted array with varying length is: %1$,.2f", val));
    }

    private double findMedianSortedArray(int[] input1, int[] input2) {

        if (input1.length > input2.length) {
            return findMedianSortedArray(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = partitionY == 0 ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if (((x + y) % 2) == 0) {
                    return ((double) Math.max(maxLeftY, maxLeftX) + Math.min(minRightX, minRightY)) / 2;
                } else return (double) Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY) high = partitionX - 1;
            else low = partitionX + 1;

        }

        throw new IllegalArgumentException();
    }
}

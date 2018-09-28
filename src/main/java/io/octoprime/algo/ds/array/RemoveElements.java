package io.octoprime.algo.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * To remove some elements from an ArrayList while iterating over the ArrayList, we need to use Iterator.
 */
public class RemoveElements {

    public int removeElement(int[] A, int elem) {
        int i = 0;
        int j = 0;

        while (j < A.length) {
            if (A[j] != elem) {
                A[i] = A[j];
                i++;
            }

            j++;
        }

        return i;
    }

    void removeElements() {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        System.out.println(list);

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int i = iter.next();
            if (i == 5)
                iter.remove();
        }

        System.out.println(list);
    }


    /**
     * Problem
     * Given a sorted array, remove the duplicates in place such that each element
     * appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with
     * constant memory.
     * Example
     * Given input array A = [1,1,2] ,
     * Your function should return length = 2, and A is now [1,2] .
     */
    public class RemoveDuplicates {

        /**
         * @param nums: a array of integers
         * @return : return an integer
         */
        public int removeDuplicates(int[] nums) {
            int a = 0, b = 0;
            while (b < nums.length) {
                nums[a++] = nums[b++];
                while (b < nums.length && nums[b] == nums[b - 1]) b++
                        ;
            }
            return a;
        }

    }

}

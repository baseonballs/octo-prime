package io.octoprime.algo.ds.array;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears
 * more than ⌊ n/2 ⌋ times. (assume that the array is non-empty and the majority element always exist in the array.)
 * <p>
 * We can sort the array first, which takes time of nlog(n). Then scan once to find the longest consecutive substrings.
 */
public class MajorityElement1 {

    public int majorityElement(int[] num) {
        if (num.length == 1) {
            return num[0];
        }

        Arrays.sort(num);

        int prev = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == prev) {
                count++;
                if (count > num.length / 2) return num[i];
            } else {
                count = 1;
                prev = num[i];
            }
        }

        return 0;
    }
}

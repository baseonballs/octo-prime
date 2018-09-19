package io.octoprime.algo.strings;

import java.util.Arrays;

public class StringPermutation {

    /**
     * Determine if a and b are permutation of each other;
     */

    public boolean isPermutation(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return new String(a).equals(new String(b));
    }
}

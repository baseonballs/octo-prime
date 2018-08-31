package io.octoprime.algo.strings;


/**
 * Problem
 * For a given source string and a target string, you should output the first index(from
 * 0) of target string in source string.
 * If target does not exist in source, just return -1.
 * Example
 * If source = "source" and target = "target", return -1.
 * If source = "abcdabcdefg" and target = "bcd", return 1.
 * Challenge O(n^2) is acceptable. Can you implement an O(n) algorithm? (hint:
 * KMP)
 */
public class StrStr {

    /**
     * Returns a index to the first occurrence of target in sour
     * ce,
     * or -1 if target is not part of source.
     *
     * @param source string to be scanned.
     * @param target string containing the sequence of character
     *               s to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) return -1;
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        if (t.length == 0) return 0;
        int i, j;
        for (i = 0; i < s.length; i++) {
            for (j = 0; j < t.length; j++) {
                if (i + j >= s.length || s[i + j] != t[j]) {
                    break;
                }
            }
            if (j == t.length) return i;
        }
        return -1;
    }

}

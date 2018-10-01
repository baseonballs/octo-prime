package io.octoprime.algo.strings;


/**
 * Problem
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 * Example
 * Given s="abcd" , t="dcab" , return true.
 */
public class Anagram {


    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return : if string A contains all of the characters in
     * B return true else return false
     */
    public boolean anagram(String A, String B) {
        int[] cnt = new int[26];
        for (char c : A.toCharArray()) {
            cnt[c - 'A']++;
        }
        for (char b : B.toCharArray()) {
            if (cnt[b - 'A'] == 0) {
                return false;
            }
            cnt[b - 'A']--;
        }
        return true;
    }

    /**
     * @param s
     * @param t
     * @return
     */
    public boolean anagram2(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int[] cnt = new int[256];
        int sizeS = s.length();
        int sizeT = t.length();
        if (sizeS != sizeT) {
            return false;
        }
        for (int i = 0; i < sizeS; i++) {
            if (s.charAt(i) != ' ') {
                cnt[s.charAt(i)]++;
            }
        }
        for (int i = 0; i < sizeT; i++) {
            if (t.charAt(i) != ' ') {
                cnt[t.charAt(i)]--;
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }


}

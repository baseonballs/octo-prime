package io.octoprime.algo.strings;

/**
 * Java program to find all permutations of a given String using recursion. * For example, given a String "XYZ", this program will print all 6 possible permutations of * input e.g. XYZ, XZY, YXZ, YZX, ZXY, XYX * * @author Javin Paul
 */


public class PermuteString {


    public static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    public static void permutation(String input) {
        permutation("", input);
    }

    public static void main(String[] args) {
        permutation("1234");
    }
}

package io.octoprime.algo.strings;

/**
 * Java program to find all permutations of a given String using recursion. * For example, given a String "XYZ", this program will print all 6 possible permutations of * input e.g. XYZ, XZY, YXZ, YZX, ZXY, XYX * * @author Javin Paul
 */


public class PermuteString {


    public static void permutation(String pre, String phrase) {
        if (phrase.isEmpty()) {
            System.out.println(pre + phrase);
        } else {
            for (int i = 0; i < phrase.length(); i++) {
                permutation(pre + phrase.charAt(i),
                        phrase.substring(0, i) +
                                phrase.substring(i + 1));
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

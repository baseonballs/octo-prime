package io.octoprime.algo.strings;

public class StringPlay {


    public static void permute(String prefix, String pattern) {
        if (pattern.isEmpty())
            System.out.println(prefix + pattern);
        else {
            int n = pattern.length();

            for (int i = 0; i < n; i++) {
                permute(prefix + pattern.charAt(i), pattern.substring(0, i) + pattern.substring(i + 1, n));
            }
        }
    }

    public static void main(String[] args) {
        String a = "abc";

        System.out.println("input string  : " + a);
        permute("", a);
    }
}

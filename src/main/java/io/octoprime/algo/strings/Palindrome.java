package io.octoprime.algo.strings;

public class Palindrome {


    public static boolean isPalindrom(String text) {
        String reverse = reverse(text);
        if (text.equals(reverse)) {
            return true;
        }
        return false;
    }

    public static boolean isPalindromIter(String input) {

        if (input == null || input.isEmpty()) return true;

        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        String rev = sb.toString();
        return input.equals(rev);
    }

    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
    }

    public static void main(String[] args) {

        String text = "11211";
        boolean bIsPalindrom = isPalindromIter(text);

        System.out.println(String.format("Is %s a plalindome: " + (bIsPalindrom ? "true" : "false"), text));
    }

}

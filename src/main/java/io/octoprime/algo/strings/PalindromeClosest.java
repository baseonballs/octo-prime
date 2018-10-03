package io.octoprime.algo.strings;

public class PalindromeClosest {

    public int findDistancePalindrome(String val) {

        int num = Integer.parseInt(val);

        if (num < 0) {
            return -1;
        }

        /**
         * special case: 100 -> 99 palindrome is closest
         */
        if (num != 1 && isPower10(num)) {
            return num - 1;
        }
        String value = num + "";

        /**
         * Deal with first partition; lower false;
         */
        String part1 = value.substring(0, ((value.length() + 1) / 2));
        int numPalindrome1 = Integer.parseInt(reverse(part1, value.length() / 2));

        /**
         * if the "lower" palindrome is found, increase by 1 or if the "higher" palindrome is found, decrease by 1
         * Deal with second partition; upper half.
         */
        int distance = numPalindrome1 <= num ? 1 : -1;
        String part2 = (Integer.parseInt(part1) + distance) + "";
        int numPalindrom2 = Integer.parseInt(reverse(part2, value.length() / 2));

        /**
         * if numPalindrom2 has more of a distance than numPalindrome1, return numPalindrome1 (smallest)
         */
        return Math.abs(num - numPalindrome1) <= Math.abs(numPalindrom2 - num) ? numPalindrome1 : numPalindrom2;
    }

    private static String reverse(String left, int n) {
        String reverse = new StringBuilder(left.substring(0, n)).reverse().toString();
        return left + reverse;
    }

    private static boolean isPower10(int x) {
        while (x > 9 && x % 10 == 0)
            x /= 10;
        return x == 1;
    }

    public static void main(String[] args) {

        String input = "123";

        System.out.println(new PalindromeClosest().findDistancePalindrome(input));

    }
}

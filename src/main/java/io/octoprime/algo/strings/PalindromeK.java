package io.octoprime.algo.strings;

/**
 * Given a string, find out if the string is K-Palindrome or not. A k-palindrome string transforms into a
 * palindrome on removing at most k characters from it.
 * <p>
 * Input : String - abcdecba, k = 1
 * Output : Yes
 * String can become palindrome by remo-
 * -ving 1 character i.e. either d or e)
 * <p>
 * <p>
 * Input  : String - abcdeca, K = 2
 * Output : Yes
 * Can become palindrome by removing
 * 2 characters b and e.
 * <p>
 * Input : String - acdcb, K = 1
 * Output : No
 * String can not become palindrome by
 * removing only one character.
 */
public class PalindromeK {


    // find if given string is K-Palindrome or not
    private static int findPalindromicKSegment(String str1, String str2, int m, int n) {
        // If first string is empty, the only option is to
        // remove all characters of second string
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, ignore
        // last characters and get count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return findPalindromicKSegment(str1, str2, m - 1, n - 1);

        // If last characters are not same,
        // 1. Remove last char from str1 and recur for m-1 and n
        // 2. Remove last char from str2 and recur for m and n-1
        // Take minimum of above two operations
        return 1 + Math.min(findPalindromicKSegment(str1, str2, m - 1, n), // Remove from str1
                findPalindromicKSegment(str1, str2, m, n - 1)); // Remove from str2
    }

    private static String reverseInPlace(String input) {
        char[] chars = input.toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }

        return new String(chars);
    }

    /**
     * Returns true if str is k palindrome.
     *
     * @param str
     * @param k
     * @return
     */
    static boolean isKPalindrome(String str, int k) {
        String rev = reverseInPlace(str);
        return (findPalindromicKSegment(str, rev, str.length(), rev.length()) <= k * 2);
    }

    public static void main(String[] args) {
        String str = "acdcb";
        int k = 2;

        System.out.println("Input String: " + str);
        System.out.println("Is K-String Palindromic: " + String.format(isKPalindrome(str, k) ? "Yes" : "No"));
    }
}

package io.octoprime.algo.strings;

public class PalindromicString {

    private static final char[] charMap = new char[256];

    static {
        for (int i = 0; i < 10; i++) {
            charMap[i + '0'] = (char) (1 + i);  // numeric
        }
        for (int i = 0; i < 26; i++) {
            charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i);  //alphabetic, ignore cases
        }
    }

    public static boolean isPalindromeOptimized(String s) {
        char[] pChars = s.toCharArray();
        int start = 0, end = pChars.length - 1;
        char cS, cE;
        while (start < end) {
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if (cS != 0 && cE != 0) {
                if (cS != cE) return false;
                start++;
                end--;
            } else {
                if (cS == 0) start++;
                if (cE == 0) end--;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s == null)
            return false;

        return isPalindromic(s.toLowerCase(), 0, s.length() - 1);
    }

    public static boolean isPalindromic(String s, int l, int r) {
        if (l >= r)
            return true;
        if ((s.charAt(l) < 'a' || s.charAt(l) > 'z') && (s.charAt(l) < '0' || s.charAt(l) > '9'))
            return isPalindromic(s, ++l, r);
        else if ((s.charAt(r) < 'a' || s.charAt(r) > 'z') && (s.charAt(r) < '0' || s.charAt(r) > '9'))
            return isPalindromic(s, l, --r);
        else if (s.charAt(l) != s.charAt(r))
            return false;

        return isPalindromic(s, ++l, --r);
    }


    public static void main(String[] args) {


        String text = "11211";
        boolean bIsPalindrom = isPalindromeOptimized(text);

        System.out.println(String.format("Is %s a plalindome: " + (bIsPalindrom ? "true" : "false"), text));
    }

}

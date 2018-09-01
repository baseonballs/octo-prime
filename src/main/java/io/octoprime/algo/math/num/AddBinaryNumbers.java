package io.octoprime.algo.math.num;

/**
 * Problem
 * Given two binary strings, return their sum (also a binary string).
 * Example
 * a = 11, b = 1
 * Return 100
 */
public class AddBinaryNumbers {

    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        char[] aa = reverse(a.toCharArray());
        char[] bb = reverse(b.toCharArray());
        int len = Math.max(aa.length, bb.length);
        int carry = 0;
        String r = "";
        for (int i = 0; i < len; i++) {
            int t = carry;
            if (i < aa.length) {
                t += (aa[i] - '0');
            }
            if (i < bb.length) {
                t += (bb[i] - '0');
            }
            carry = t / 2;
            r += (t % 2 == 0 ? '0' : '1');
        }
        if (carry == 1) {
            r += "1";
        }
        return new String(reverse(r.toCharArray()));
    }

    private char[] reverse(char[] c) {
        int i = 0, j = c.length - 1;
        while (i < j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
        return c;
    }

}

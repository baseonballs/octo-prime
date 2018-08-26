package io.octoprime.algo.math.num;

import io.octoprime.utils.UtilsArray;

import java.util.Arrays;

public class Numbers {

    /*
        Integer.toBinaryString(n);
        Integer.toOctalString(n);
        Integer.toHexString(n);

     */
    static class ConversionComparator {

        // return Integer.parseInt(""+n,b);
        public int toDecimal(int n, int b) {
            int result = 0;
            int multiplier = 1;


            while (n > 0) {
                result += (n % 10) * multiplier;
                multiplier = b;
                n /= 10;
            }
            return result;
        }

        public int fromDecimal(int n, int b) {
            int result = 0;
            int multiplier = 1;

            while (n > 0) {
                result += (n % b) * multiplier;
                multiplier = 10;
                n /= b;
            }
            return result;
        }

        public String fromDecimal2(int n, int b) {
            String chars = "0123456789ABCDEFGHIJ";
            String result = "";

            while (n > 0) {
                result = chars.charAt(n % b) + result;
                n /= b;
            }
            return result;
        }

    }

    public static class Fraction {

        public int[] multiplyFractions(int[] a, int[] b) {
            int[] c = {a[0] * b[0], a[1] * b[1]};
            return c;
        }

        public int[] addFractions(int[] a, int[] b) {
            int denom = LCM.lcm(a[1], b[1]);

            int[] c = {denom / a[1] * a[0] + denom / b[1] * b[0], denom};
            return c;
        }

        public void reduceFraction(int[] a) {
            int b = LCM.gcd(a[0], a[1]);
            a[0] /= b;
            a[1] /= b;
        }

    }

    public static int findMin(int[] arr) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        return index;
    }

    static void testMinValue() {

        UtilsArray units = new UtilsArray();

        int[] arrs = units.randomArrayAsInt(10, 10000);

        System.out.println(Arrays.toString(arrs));
        System.out.println(String.format("Index of min key is: %d", findMin(arrs)));

        // (new BubbleSort()).sort(arrs);
        System.out.println(Arrays.toString(arrs));

    }

    public static void main(String[] args) {
    }
}

package io.octoprime.algo.math.num;

public class BaseConversion {


    /**
     * Given a number in base 10, it returns the binary representation as a string denoted by size.
     *
     * @param n    the decomal number
     * @param size the number of bits to gnerate
     * @return String the binary converstion of the decimal value.
     */
    public String decToBinary(int n, int size) {
        int[] bin = new int[size];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            bin[i] = n % 2;
            n >>>= 1;
        }

        // reverse the ordered bits
        for (int j = size - 1; j >= 0; j--)
            sb.append(bin[j]);

        return sb.toString();
    }


    /**
     * Problem
     * * Given an integer, convert it to a roman numeral.
     * * The number is guaranteed to be within the range from 1 to 3999.
     *
     * @param n The integer
     * @return Roman representation
     */
    public String decToRomanNumeral(int n) {
        int[] s = new int[4];
        for (int i = 0; i < 4; i++) {
            s[i] = n % 10;
            n /= 10;
        }
        String[][] map = new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", " LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", " DCCC", "CM"},
                {"", "M", "MM", "MMM"}};
        String result = "";
        int k = 3;
        while (s[k] == 0) k--;
        while (k >= 0) {
            result += map[k][s[k]];
            k--;
        }
        return result;
    }

    public String decToHex(int num) {
        StringBuilder sb = new StringBuilder();

        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while (num > 0) {
            sb.append(hex[num % 16]);
            num = num / 16;
        }

        return sb.reverse().toString();
    }

    public static byte[] hexToBin2(String str) {
        int len = str.length();
        byte[] out = new byte[len / 2];
        int endIndx;

        for (int i = 0; i < len; i = i + 2) {
            endIndx = i + 2;
            if (endIndx > len)
                endIndx = len - 1;
            out[i / 2] = (byte) Integer.parseInt(str.substring(i, endIndx), 16);
        }
        return out;
    }

    public static int hexToBin(String hex) {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;

        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16 * val + d;
        }

        return val;
    }


    public static void main(String[] args) {
        int num = 256;
        int size = 16;

        System.out.println(String.format("The number is : %d", num));
        System.out.println(String.format("The number in binary is : %s", new BaseConversion().decToBinary(num, size)));
        System.out.println(String.format("The number in hex is : %s", new BaseConversion().decToHex(num)));
        System.out.println(String.format("The number in roman is : %s", new BaseConversion().decToRomanNumeral(num)));
    }
}

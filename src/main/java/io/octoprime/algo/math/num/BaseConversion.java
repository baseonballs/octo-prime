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
        // array to store binary number
        int[] bin = new int[size];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            bin[i] = n % 2;
            n >>>= 1;
        }

        // printing binary array in reverse order
        for (int j = size - 1; j >= 0; j--)
            sb.append(bin[j]);

        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 15;
        int size = 8;

        System.out.println(String.format("The number is : %d", num));
        System.out.println(String.format("The number is : %s", new BaseConversion().decToBinary(num, size)));
    }
}

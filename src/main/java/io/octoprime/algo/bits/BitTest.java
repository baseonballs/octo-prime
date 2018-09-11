package io.octoprime.algo.bits;

public class BitTest {


    /**
     * The hammer weight of a decimal number. The idea is to count the number of 1s in the range of bits bound
     * by the data type.  Since we are using int, the size is 32 bits.  We loop through each of the 32 bits
     * and tests for 1. If so, bump the count.
     *
     * @param number
     * @return
     */
    public static int countOnes(int number) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((number & 1) == 1) count++;
            number >>>= 1;
        }

        return count;
    }

    /**
     * Now if you write this method, Interviewer will most likely ask you about optimization.
     * If you look closely, you can see that this method always loop 32 times, which is size of int.
     * If you write similar method for long, it will loop 64 times, can you think what to optimize now?
     * You can optimize this loop. Instead of making loop proportional to size of bits, you can make it
     * proportional to number of put bits.
     * *
     *
     * @param number
     * @return
     */
    public static int countOnesOptimized(long number) {
        int count = 0;
        while (number > 0) {
            ++count;
            number &= number - 1;
        }
        return count;
    }


    public static boolean isSet(int flag, int bit) {
        return (flag & bit) == 1;
    }


    public static boolean isSigned(int n) {
        return n >> 31 == 1;
    }

    /**
     * You can turn off a bit by anding with a binary number of all 1's, except for the bit to be put.
     * <p>
     * 01010101 & ~(1<<2) == 01010101 & 11111011 == 01010001
     *
     * @return
     */
    public static int setBit(int flag, int bit, boolean setIt) {
        if (setIt)
            flag |= (1 << bit);
        else flag &= (1 << bit);

        return flag;
    }


    /**
     * @param arg
     */
    public static void main(String[] arg) {

        int num = 3;

        System.out.println(String.format("hammer weight of (%d): %s", num, countOnes(num)));
    }
}

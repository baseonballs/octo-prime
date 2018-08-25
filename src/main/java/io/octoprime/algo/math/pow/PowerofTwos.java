package io.octoprime.algo.math.pow;

public class PowerofTwos {

    public static boolean isPowerOfTwos(int n) {

        while ((n % 2) == 0)
            n >>= 1;

        return n == 1;
    }

    public static boolean isPowerOfTwosBits(int n) {
        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {

        System.out.println("128 is power of two : " + isPowerOfTwos(128));
        System.out.println("64 is power of two : " + isPowerOfTwosBits(64));
        System.out.println("22 is power of two : " + isPowerOfTwosBits(22));
        System.out.println("22 is power of two : " + isPowerOfTwos(22));
        System.out.println("1 is power of two : " + isPowerOfTwos(1));

    }

}

package io.octoprime.algo.bits;

public class BitTiddler {

    //2n == (1 << n); 0 <= n < 32

    public static int getPowerOfTwo(int size) {
        int n = -1;
        while (size >> ++n > 0) ;
        return (1 << n - 1 == size) ? size : 1 << n;
    }

    public static int getNextPowerOfTwo(int size) {
        int n = -1;
        while (size >> ++n > 0) ;
        return 1 << n;
    }

    public static int getPreviousPowerOfTwo(int size) {
        int n = -1;
        while (size >> ++n > 0) ;
        return 1 << n - 1;
    }


    public static void displayNextPowersOfTwo(int size) {
        int n = -1;
        while (size >> ++n > 0) {
            System.out.print((1 << n) + ",");
        }
        System.out.print('\n');
    }


    public static void test1() {
        System.out.println(String.format("Power of 2s, 2 ^ %d = %d", 0, 2 << -1));
        for (int i = 0; i < 4; i++) {
            System.out.println(String.format("Power of 2s, 2 ^ %d = %d", i, 2 << i));
        }
    }

    public static void xorSwap() {
        int a = 1, b = 2;

        System.out.println(String.format("a: %d, b: %d", a, b));
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(String.format("a: %d, b: %d", a, b));
    }

    public static void main(String[] arg) {
        //  test1();
        displayNextPowersOfTwo(512 << 2);
    }
}

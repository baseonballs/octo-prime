package io.octoprime.algo.math;

import java.util.Scanner;

public class Power {


    public static double negpow(int base, int k) {
        if (k <= 0) return 1;

        if (k < 0) return 1 / (power(base, k - 1) * base);
        else return negpow(base, k - 1) * base;
    }


    public static int power(int base, int k) {
        if (k <= 0) return 1;
        return power(base, k - 1) * base;
    }

    public static int powerIt(int base, int k) {
        int a = 1;

        while (k > 0) {
            if ((k % base) != 0)
                a = a * base;

            k = k / 2;
            base = base * base;
        }

        return a;
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base and exponent:");
        int base = scanner.nextInt();
        int exponent = scanner.nextInt();

        System.out.println(String.format("The power(%d,%d) is : %d", base, exponent, powerIt(base, exponent)));
    }
}

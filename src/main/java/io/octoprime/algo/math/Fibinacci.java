package io.octoprime.algo.math;

import java.util.Scanner;

public class Fibinacci {

    public static int fibRecur(int n) {
        if (n <= 1) return n;
        return fibRecur(n - 1) + fibRecur(n - 2);
    }

    public static int fibIter(int nth) {
        int a = 0, b = 1, x = 0;

        for (int i = 2; i < nth + 1; i++) {
            x = a + b;
            a = b;
            b = x;
        }

        return x;
    }


    public static int fibDP(int n) {
        int[] f = new int[n + 2];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }


    /*
        { 0, 1, 1, 2, 3, 5, 8, 13, 21,...}
     */
    public static void main(String[] arg) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter nth for the fibinacci number.");
        int n = scan.nextInt();
        System.out.println(String.format("Fib: %d", fibDP(n)));
    }
}

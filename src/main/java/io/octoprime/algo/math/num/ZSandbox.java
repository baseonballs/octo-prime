package io.octoprime.algo.math.num;

public class ZSandbox {


    public static int fibi(int n) {
        if (n <= 1) return n;

        return fibi(n - 1) + fibi(n - 2);
    }

    public static int fib(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }


    public static int fact(int n) {
        if (n <= 1) return 1;

        return n * fact(n - 1);
    }

    public static int facti(int n) {
        int sum = 1;

        for (int i = 2; i <= n; i++)
            sum *= i;

        return sum;
    }

    // 0, 1, 1, 2, 3, 5, 8, 13,
    public static void main(String[] args) {

        int n = 7;
        int fn = 4;

        int f = fibi(n);
        int ff = facti(fn);

        System.out.println("fib is: " + f);
        System.out.println("factorial is: " + ff);

    }
}

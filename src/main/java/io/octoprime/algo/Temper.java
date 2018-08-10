package io.octoprime.algo;

import io.octoprime.AbstractUtils;
import io.octoprime.algo.math.Factorial;


public class Temper extends AbstractUtils {


    /*
      { 0, 1, 1, 2, 3, 5, 8, 13, 21,...}
   */
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    static int fib1(int n) {

        int a = 0, b = 1, sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }

    static int fib2(int n) {
        int[] arr = new int[n + 2];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static void main(String[] arg) {

        int[] arr = randomizeArray(10);

        int nth = 3;

        int n = (new Factorial()).factorialIter(nth);
        System.out.println(String.format("fact of %d is %d", nth, n));

    }
}

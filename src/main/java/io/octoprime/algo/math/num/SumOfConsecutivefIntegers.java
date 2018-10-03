package io.octoprime.algo.math.num;

/**
 * sum of consecutive integer is ( n * (n+1) ) / 2
 */
public class SumOfConsecutivefIntegers {

    static int sumr(int a, int n) {
        if (a == n)
            return n;
        else
            return a + sumr(a + 1, n);
    }

    static int sumi(int a, int n) {
        int sum = 0;

        for (int i = a; i <= n; i++)
            sum += i;

        return sum;
    }

    public static void main(String[] args) {
        int a = 1;
        int n = 10;
        System.out.println("Sum from " + a + " to " + n + " is: " +
                sumi(a, n));
    }

}

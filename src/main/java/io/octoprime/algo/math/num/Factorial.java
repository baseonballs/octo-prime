package io.octoprime.algo.math.num;

public class Factorial {

    public int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }

    public int factorialIter(int n) {
        int sum = 1;

        for (int i = 2; i <= n; i++)
            sum *= i;

        return sum;
    }
}

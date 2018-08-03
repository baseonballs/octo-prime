package io.octoprime.algo.math;

public class PrimeExponentization {

    private static long PRIME = 1000000007;        // Or any prime

    // Returns (x^n) % PRIME
    private long binary_exp(long x, long n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x % PRIME;
        } else {
            long temp = binary_exp(x, n / 2);
            temp = (temp * temp) % PRIME;

            if (n % 2 == 0) {
                return temp;
            } else {
                return ((x % PRIME) * temp) % PRIME;
            }
        }
    }

}

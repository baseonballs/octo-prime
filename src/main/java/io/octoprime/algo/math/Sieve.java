package io.octoprime.algo.math;

import java.util.Arrays;
import java.util.Scanner;

public class Sieve {

    private static boolean DEBUG = false;

    /*
     ** We build a array of boolean which indicates the state of prime for the indexed key.
     */
    public boolean[] sieve(int n) {
        boolean[] isPrimes = new boolean[n + 1];

        Arrays.fill(isPrimes, true);
        if (DEBUG)
            System.out.println("calc::before:" + Arrays.toString(isPrimes));

        for (int p = 2; p * p <= n; p++) {
            if (isPrimes[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    isPrimes[i] = false;
                }
            }
        }

        if (DEBUG)
            System.out.println("calc::after:" + Arrays.toString(isPrimes));

        return isPrimes;
    }

    public static int printPrimes(boolean[] isPrimes) {
        int k = 0;
        for (int i = 2; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                System.out.print(i + " ");
                k++;
            }
        }
        return k;
    }

    //
    boolean isPrime(int number) {

        if (number == 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int d = 3; d <= (int) Math.sqrt((double) number); d++)
            if (number % d == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();

        System.out.println("num primes: " + Sieve.printPrimes((new Sieve()).sieve(n)));
    }
}

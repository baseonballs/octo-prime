package io.octoprime.algo;

import java.util.Arrays;
import java.util.Random;


public class Temper {

    static Random random = new Random();

    private static int[] generateRandomArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(100);

        return arr;
    }


    private static boolean[] sieve(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int p = 2; p * p <= n; p++)
            if (primes[p] == true) {
                for (int x = 2 * p; x < primes.length; x += p)
                    primes[x] = false;
            }

        return primes;
    }


    public static void main(String[] arg) {

        boolean[] primes = sieve(3);
        for (int i = 2; i < primes.length; i++)
            if (primes[i]) System.out.print(i + " ");
    }
}

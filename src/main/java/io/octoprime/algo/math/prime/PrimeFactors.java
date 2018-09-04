package io.octoprime.algo.math.prime;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.sqrt;

public class PrimeFactors {

    /**
     * @param number
     * @return
     */
    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    /**
     * Optimized using sqrt(n).
     * @param numbers
     * @return
     */
    public static List<Integer> primeFactors2(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= sqrt(n); i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }


    public static void main(String[] args) {

        System.out.println("Primefactors of 2");
        for (Integer integer : primeFactors2(2)) {
            System.out.print(integer + " ");
        }

        System.out.println("\nPrimefactors of 10");
        for (Integer integer : primeFactors2(10)) {
            System.out.print(integer + " ");
        }

        System.out.println("\nPrimefactors of 44");
        for (Integer integer : primeFactors2(44)) {
            System.out.print(integer + " ");
        }

        System.out.println("\nPrimefactors of 3");
        for (Integer integer : primeFactors2(3)) {
            System.out.print(integer + " ");
        }
        System.out.println("\nPrimefactors of 32");
        for (Integer integer : primeFactors2(32)) {
            System.out.print(integer + " ");
        }
    }

}

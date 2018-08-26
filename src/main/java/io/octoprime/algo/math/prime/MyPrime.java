package io.octoprime.algo.math.prime;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MyPrime {

    public static void printPrimes(int n) {
        int num = 0;


        System.out.println("\nPrime NumberConversion up to " + n + ".");

        for (int i = 1; i <= n; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter++;
                }
            }

            // Counter = 2 means number is only divisible by 1 and the number itself. So it's a prime number.
            if (counter == 2) {
                System.out.print(i + " ");
            }
        }
    }

    public boolean isPrime3(int number) {
        BigInteger bigInt = BigInteger.valueOf(number);
        return bigInt.isProbablePrime(100);
    }

    public boolean isPrime2(int number) {
        return number > 2
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }

    public static boolean isPrime(int n) {

        if (n <= 1) return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0) return false;

        return true;
    }

    public static boolean isPrime1(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public boolean isPrimeOptimized(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int m = (int) Math.sqrt(n);

        for (int i = 3; i <= m; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }


    // A function to print all prime factors
    // of a given number n
    public static void primeFactors(int n) {
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            System.out.print(n);
    }

    public static void testPrimeFactorization(int n) {
        primeFactors(n);
    }

    public static void testPrintPrimes(int n) {
        printPrimes(n);
        System.out.println(String.format("The number %d is %s a prime", n, (isPrime(n) == true) ? "" : "not"));
    }

    public static void main(String[] arg) {

        System.out.println("Please enter the prime number: ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        testPrimeFactorization(n);

        scanner.close();
    }
}

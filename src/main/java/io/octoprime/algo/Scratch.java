package io.octoprime.algo;

import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class Scratch {


    public static void divisors( int n )
    {
        System.out.println(String.format("Divsors of %d", n));

        for (int i=1; i <= n;i++)
        {
            if ( (n % i) == 0)
            System.out.print(i+" ");
        }

        System.out.println();
    }

    public static void factorize(int n) {

        System.out.println(String.format("Prime factors of %d", n));

        for (int i = 2; i <= n; i++) {
            while ((n % i) == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        System.out.println();
    }


    public static void main(String[] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");

        int n = scanner.nextInt();
        factorize(n);
        divisors(n);

    }
}

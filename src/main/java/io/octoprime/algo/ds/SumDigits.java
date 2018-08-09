package io.octoprime.algo.ds;

import java.util.Scanner;

public class SumDigits {

    public static int sumOfDigitsRecur(int n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDigitsRecur(n / 10);
    }

    public static int sumOfDigitsIter1(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int sumOfDigitsIter2(int n) {
        int sum = 0;

        for (; n > 0; sum += n % 10,
                n /= 10)
            ;

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println(String.format("Sum of digits for %d is %d.", n, sumOfDigitsIter1(n)));
    }
}

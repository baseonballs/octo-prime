package io.octoprime.algo.math;

import java.util.Arrays;
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

    public static void easy2SumOfTarget(int target) {
        int arr[] = new int[]{2, 2, 7, 3, 12};
        int t[] = {};

        int tar = 9;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    t = new int[2];
                    t[0] = i;
                    t[1] = j;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(t));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println(String.format("Sum of digits for %d is %d.", n, sumOfDigitsIter1(n)));
    }
}

package io.octoprime.algo.ds;

import java.util.Arrays;
import java.util.Scanner;

public class LCM {

    static class LCMArray {

        /*

        Let we have to find the LCM of
    arr[] = {1, 2, 3, 4, 28}

    We initialize result = 1.

    2 is a common factor that appears in
    two or more elements. We divide all
    multiples by two and multiply result
    with 2.
    arr[] = {1, 1, 3, 2, 14}
    result = 2

    2 is again a common factor that appears
    in two or more elements. We divide all
    multiples by two and multiply result
    with 2.
    arr[] = {1, 1, 3, 1, 7}
    result = 4

    Now there is no common factor that appears
    in two or more array elements. We multiply
    all modified array elements with result, we
    get.
    result = 4 * 1 * 1 * 3 * 1 * 7
           = 84

         */
        public static long lcmArray(int[] arr) {
            long lcm = 1;
            int divisor = 2;

            while (true) {
                int counter = 0;
                boolean divisible = false;

                for (int i = 0; i < arr.length; i++) {

                    // lcm (n1, n2, ... 0) = 0.
                    // For negative number we convert into
                    // positive and calculate lcm.

                    if (arr[i] == 0) {
                        return 0;
                    } else if (arr[i] < 0) {
                        arr[i] = arr[i] * (-1);
                    }
                    if (arr[i] == 1) {
                        counter++;
                    }

                    // Divide arr by divisor if complete
                    // division i.e. without remainder then replace
                    // number with quotient; used for find next factor
                    if (arr[i] % divisor == 0) {
                        divisible = true;
                        arr[i] = arr[i] / divisor;
                    }
                }

                // If divisor able to completely divide any number
                // from array multiply with lcm
                // and store into lcm and continue
                // to same divisor for next factor finding.
                // else increment divisor
                if (divisible) {
                    lcm = lcm * divisor;
                } else {
                    divisor++;
                }

                // Check if all arr is 1 indicate
                // we found all factors and terminate while loop.
                if (counter == arr.length) {
                    return lcm;
                }
            }
        }

        static void testLCMOfArray() {
            int[] arr = {2, 7, 3, 9, 4};
            // int[] arr = {1, 2, 3, 4/*, 5 , 10, 20, 35*/};

            System.out.println(Arrays.toString(arr));
            System.out.println("LCM of array: " + lcmArray(arr));
        }
    }

    // extended Euclidean Algorithm
    public static int gcdBasic(int a, int b) {
        if (a == 0)
            return b;

        return gcdBasic(b % a, a);
    }

    // recursive implementation
    public static int gcdBasic2(int a, int b) {
        if (b == 0) return a;
        else return gcdBasic2(b, a % b);
    }

    // Recursive method to return gcd of a and b
    public static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public static int gcdIterative0(int a, int b) {
        for (int i = Math.min(a, b); i >= 1; i--)
            if (a % i == 0 && b % i == 0)
                return i;
        return -1;
    }

    // non-recursive implementation
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /*
        a x b = LCM(a, b) * GCD (a, b)
        LCM(a, b) = (a x b) / GCD(a, b)
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }


    static void testLCM(Scanner scanner) {

        System.out.println("Enter two numbers:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int _lcm = lcm(a, b);
        System.out.println(String.format("The LCM(%d, %d) = %d.", a, b, _lcm));
    }

    public static void testGCD(Scanner scanner) {
        System.out.println("Enter two numbers:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("GCD: " + gcdIterative0(a, b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // testLCM(scanner);
        testGCD(scanner);
        // testLCMOfArray();

        scanner.close();
    }

}

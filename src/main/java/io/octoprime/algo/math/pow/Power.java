package io.octoprime.algo.math.pow;

import java.util.Scanner;

public class Power {

    /**
     * Intuition
     * <p>
     * Just simulate the process, multiply x for n times.
     * <p>
     * If n < 0n<0, we can substitute x, nx,n with \dfrac{1}{x}, -n
     * ​x
     * ​
     * ​1
     * ​​ ,−n to make sure n \ge 0n≥0. This restriction can simplify our further discussion.
     * <p>
     * But we need to take care of the corner cases, especially different range limits for negative and positive integers.
     * <p>
     * Algorithm
     * <p>
     * We can use a straightforward loop to compute the result.
     * <p>
     * Complexity Analysis: time O(n) - we multiply x for n times.
     * Space complexity: O(1); we only need one variable to store the final product of x.
     *
     * @param x
     * @param n
     * @return
     */
    public static double pow(double base, int n) {

        // normalize if n  < 0;
        long exp = n;
        if (exp < 0) {
            base = 1 / base;
            exp = -exp;
        }

        double powers = 1;
        for (long i = 0; i < exp; i++) {
            powers *= base;
        }

        return powers;
    }

    /**
     * Intuition
     * <p>
     * Assuming we have got the result of x ^ nx
     * ​n
     * ​​ , how can we get x ^ {2 * n}x
     * ​2∗n
     * ​​  ? Obviously we do not need to multiply x for another n times. Using the formula (x ^ n) ^ 2 = x ^ {2 * n}(x
     * ​n
     * ​​ )
     * ​2
     * ​​ =x
     * ​2∗n
     * ​​ , we can get x ^ {2 * n}x
     * ​2∗n
     * ​​  at the cost of only one computation. Using this optimization, we can reduce the time complexity of our algorithm.
     * <p>
     * Algorithm
     * <p>
     * Assume we have got the result of x ^ {n / 2}x
     * ​n/2
     * ​​ , and now we want to get the result of x ^ nx
     * ​n
     * ​​ . Let A be result of x ^ {n / 2}x
     * ​n/2
     * ​​ , we can talk about x ^ nx
     * ​n
     * ​​  based on the parity of n respectively. If n is even, we can use the formula (x ^ n) ^ 2 = x ^ {2 * n}(x
     * ​n
     * ​​ )
     * ​2
     * ​​ =x
     * ​2∗n
     * ​​  to get x ^ n = A * Ax
     * ​n
     * ​​ =A∗A. If n is odd, then A * A = x ^ {n - 1}A∗A=x
     * ​n−1
     * ​​ . Intuitively, We need to multiply another xx to the result, so x ^ n = A * A * xx
     * ​n
     * ​​ =A∗A∗x. This approach can be easily implemented using recursion. We call this method "Fast Power", because we only need at most O(log(n))O(log(n)) computations to get x ^ nx
     * ​n
     * ​​ .
     * <p>
     * Analysis:
     * Complexity Analysis
     * <p>
     * Time complexity : O(log(n))O(log(n)). Each time we apply the formula (x ^ n) ^ 2 = x ^ {2 * n}(x
     * ​n
     * ​​ )
     * ​2
     * ​​ =x
     * ​2∗n
     * ​​ , nn is reduced by half. Thus we need at most O(log(n))O(log(n)) computations to get the result.
     * <p>
     * Space complexity : O(log(n))O(log(n)). For each computation, we need to store the result of x ^ {n / 2}x
     * ​n/2
     * ​​ . We need to do the computation for O(log(n))O(log(n)) times, so the space complexity is O(log(n))O(log(n)).
     *
     * @param x
     */
    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static double pow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }


    /**
     * Fast Power Iterative
     * <p>
     * Analysis:
     * Complexity Analysis
     * <p>
     * Time complexity : O(log(n))O(log(n)). For each bit of n 's binary representation, we will at most multiply
     * once. So the total time complexity is O(log(n))O(log(n)).
     * <p>
     * Space complexity : O(1)O(1). We only need two variables for the current product and the final result of x.
     *
     * @param x
     * @param n
     * @return
     */
    public static double pow3(double x, int n) {
        long exp = n;
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        double result = 1;
        double prod = x;
        for (long i = exp; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                result *= prod;
            }
            prod = prod * prod;
        }
        return result;
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base: ");
        double base = scanner.nextDouble();
        System.out.println("Enter the exponent: ");
        int exponent = scanner.nextInt();

        System.out.println(String.format("The power(%f,%d) is : %f", base, exponent, pow(base, exponent)));
    }
}

package io.octoprime.algo.math.num;

public class Sqrt {

    // Returns floor of square root of x
    static int sqrtNaive(int x) {
        // Base cases
        if (x == 0 || x == 1)
            return x;

        // Staring from 1, try all numbers until
        // i*i is greater than or equal to x.
        int i = 1, result = 1;

        while (result <= x) {
            i++;
            result = i * i;
        }
        return i - 1;
    }

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x == 1) return 1;
        long low = 0;
        long high = x;
        while (low < high) {
            long mid = (low + high) / 2;
            if (mid * mid <= x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return (int) low;
    }
}

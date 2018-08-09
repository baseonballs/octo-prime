package io.octoprime.algo.math;

// sum of consecutive integer is ( n * (n+1) ) / 2

public class SumOfConsecutivefIntegers {

    static int sumRecur(int first, int last) {
        if (first == last)
            return last;
        else
            return first + sumRecur(first + 1, last);
    }

    static int sumIter(int first, int last) {
        int n = 0;

        for (int i = first; i <= last; i++)
            n += i;

        return n;
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 10;
        System.out.println("Sum from " + start + " to " + end + " is: " +
                sumIter(start, end));
    }

}

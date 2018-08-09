package io.octoprime.algo;

import io.octoprime.algo.ds.UtilsArray;
import io.octoprime.algo.sort.BubbleSort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {

    private static int fib(int n) {
        if (n < 0)
            System.out.println("bad arg.");
        if (n == 1) return 0;
        else if (n == 2) return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static long fib2(int n) {
        long x[] = new long[n + 2];

        x[0] = 0;
        x[1] = 1;


        for (int i = 2; i <= n; i++) {
            x[i] = x[i - 1] + x[i - 2];
        }

        return x[n - 1];

    }

    private static long fib3(int n) {
        int a, b, c;

        a = 0;
        b = 1;

        if (n < 0) {
            System.out.println("Bad key: " + n);
            return n;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void swap(int a, int b) {
        int t;
        System.out.println(String.format("The unswapped values are:  %d, %d", a, b));

        t = a;
        a = b;
        b = t;

        System.out.println(String.format("The swaped values are:  %d, %d", a, b));
    }

    public static void main(String[] args) {

        UtilsArray utils = new UtilsArray();

        long val = Driver.fib3(9);

        if (val > 0)
            System.out.println("The fibinacci number is : " + val);

        int n = 10;
        ArrayList<Integer> arr = utils.sequencedArrayCountingNumber(n);

        int j = n;
        Integer sum = 0;
        while (j-- > 0) {
            sum += arr.get(j);
        }

        System.out.println("arr: " + arr);

        System.out.println("sum: " + sum);
        System.out.println("sum: " + (n * (n + 1)) / 2);

        ArrayList<Integer> arrb = utils.randomArray(10, 100);
        System.out.println("random array: " + arrb);

        int[] b = arrb.stream().mapToInt(i -> i).toArray();
        (new BubbleSort()).sort(b);

        ArrayList<String> arrs = utils.stringArray(10, 8);
        System.out.println("random string array: " + arrs);

        List<String> resultList
                = arrs.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("random string array: " + resultList);

    }
}

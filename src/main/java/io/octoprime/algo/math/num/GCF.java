package io.octoprime.algo.math.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GCF {

    private static boolean DEBUG = false;

    public static List<Integer> divisors(int n) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                list.add(i);

        if (DEBUG) System.out.println("factors: " + Arrays.toString(list.toArray()));

        return list;
    }

    public static int findmax(Integer[] list) {
        int max = Integer.MIN_VALUE;
        for (Integer e : list) {
            if (e.intValue() > max)
                max = e.intValue();
            if (DEBUG) System.out.print(e.toString() + " ");
        }

        return max;
    }

    public static int findmin(Integer[] list) {
        int min = Integer.MAX_VALUE;
        for (Integer e : list) {
            if (e.intValue() < min)
                min = e.intValue();
            if (DEBUG) System.out.print(e.toString() + " ");
        }

        return min;
    }


    public static boolean isCoPrime(Integer[] result) {
        return findmax(result) == 1;
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers, a and b");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        List<Integer> alist = divisors(a);
        List<Integer> blist = divisors(b);

        System.out.println("\ndivisors for a " + Arrays.toString(alist.toArray(new Integer[alist.size()])));
        System.out.println("\ndivisors for b " + Arrays.toString(blist.toArray(new Integer[alist.size()])));

        alist.retainAll(blist);

        Integer[] result = alist.toArray(new Integer[alist.size()]);

        System.out.println("\nGreatest common factor is : " + findmax(result));
        System.out.println("\nLeast common factor is : " + findmin(result));

        System.out.println("Is Relative Prime : " + (isCoPrime(result) == true ? "yes" : "no"));
    }
}

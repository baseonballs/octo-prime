package io.octoprime.algo.math.num;

import java.util.Scanner;

public class Add2NumWithOutAddOrSub {


    /**
     * @param a
     * @param b
     * @return
     */
    public static int sum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    public static void main(String[] arg) {
        int x, y;
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number: ");
        x = in.nextInt();
        System.out.print("Input second number: ");
        y = in.nextInt();

        System.out.print("Sum: " + sum(x, y));
        System.out.print("\n");
    }
}

package io.octoprime.algo.math.num;

import java.util.Scanner;

public class Add2NumWithOutAddOrSub {


    /**
     * @param x
     * @param y
     * @return
     */
    public static int sum(int x, int y) {
        while (y != 0) {
            int carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }

        return x;
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

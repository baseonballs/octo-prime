package io.octoprime.algo;

import io.octoprime.algo.strings.UtilsString;

public class Practice {


    public static void easy1ReverseString() {
        System.out.println("Easy #1: ");
        System.out.println("---------");
        String s = "hello";
        System.out.println("source string: " + s);
        System.out.println("reverse string: " + UtilsString.reverseString(s));

    }


    public static void main(String[] args) {
        int x = 1028;

        System.out.println("Value is :" + x);
        // easy1ReverseString();

        boolean isPowerOfTwo = ((x & (x - 1)) == 0);
        System.out.println("Is Power of 2: " + (isPowerOfTwo ? "true" : "false"));

        //  easy2SumOfTarget(5);
    }
}

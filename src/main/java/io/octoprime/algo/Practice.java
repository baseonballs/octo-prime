package io.octoprime.algo;

import io.octoprime.algo.strings.UtilsString;

import java.util.Arrays;

public class Practice {



    public static void easy1ReverseString()
    {
        System.out.println("Easy #1: ");
        System.out.println("---------");
        String s = "hello";
        System.out.println("source string: " + s);
        System.out.println("reverse string: " + UtilsString.reverseString(s));

    }

    public static void easy2SumOfTarget(int target)
    {
        int arr[] = new int[] { 2,2,7,3,12 };
        int t[] = {};

        int tar = 9;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i+1; j < arr.length; j++)
            {
                int sum = arr[i] + arr[j];
                if ( sum == target)
                {
                    t = new int [2];
                    t[0] = i;
                    t[1] = j;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(t));

    }
    public static void main(String[] args)
    {
        int x = 1028;

        System.out.println("Value is :" + x);
       // easy1ReverseString();

        boolean isPowerOfTwo = (boolean) ((x & (x-1)) == 0);
        System.out.println("Is Power of 2: "  +  (isPowerOfTwo ? "true":"false"));

      //  easy2SumOfTarget(5);
    }
}

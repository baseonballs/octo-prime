package io.octoprime;

import java.util.Random;

public abstract class AbstractUtils {

    private static Random random = new Random();

    protected static int[] randomizeArray(int size) {

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(100);

        return arr;
    }
}

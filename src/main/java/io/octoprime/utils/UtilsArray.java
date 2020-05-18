package io.octoprime.utils;

import io.octoprime.algo.strings.UtilsString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class UtilsArray {

    private static Random _random = new Random();

    public static int[] makeIntArray(Stream s) {
        return (s.filter(e -> e != null).mapToInt(e -> (int) e).toArray());
    }

    public int[] sequencedArrayWholeNumber(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>(n + 1);

        for (int i = 0; i <= n; i++)
            arr.add(i);

        return makeIntArray(arr.stream());
    }

    public static ArrayList<Integer> sequencedArrayCountingNumber(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++)
            arr.add(i + 1);

        return arr;
    }

    public int[] sequencedArrayCountingNumberAsInt(int n) {
        ArrayList<Integer> arr = sequencedArrayCountingNumber(n);

        return makeIntArray(arr.stream());
    }


    public static ArrayList<Integer> randomArray(int n, int range) {
        ArrayList<Integer> arr = new ArrayList<Integer>(n);

        int j = n;

        while (j-- > 0)
            arr.add(_random.nextInt(range));

        return arr;
    }

    private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
    }
    
    public static int randomBetween(int min, int max)
    {
        return _random.nextInt((max - min) + 1) + min;
    }
    
    public static ArrayList<Integer> randomArrayRange(int n, int min, int max)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>(n);

        while (n-- > 0)
        {
            arr.add(getRandomNumberInRange(min, max));
        }
        return arr;
    }

    public static int[] randomArrayAsInt(int n, int range) {
        ArrayList<Integer> arr = randomArray(n, range);

        return makeIntArray(arr.stream());
    }

    public static ArrayList<String> stringArray(int n, int size) {
        ArrayList<String> arr = new ArrayList<String>(n);

        int j = n;
        while (j-- > 0) {
            arr.add(UtilsString.randomStringAlpha(size));
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        System.out.println(Arrays.toString(arr));
    }

}

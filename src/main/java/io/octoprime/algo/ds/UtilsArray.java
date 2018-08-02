package io.octoprime.algo.ds;

import io.octoprime.algo.strings.UtilsString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class UtilsArray {

    private Random _random = new Random();

    public static int[] makeIntArray(Stream s) {
        return s.filter(e -> e != null).mapToInt(e -> (int) e).toArray();
    }

    public int[] sequencedArrayWholeNumber(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>(n + 1);

        for (int i = 0; i <= n; i++)
            arr.add(i);

        return makeIntArray(arr.stream());
    }

    public ArrayList<Integer> sequencedArrayCountingNumber(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++)
            arr.add(i + 1);

        return arr;
    }

    public int[] sequencedArrayCountingNumberAsInt(int n) {
        ArrayList<Integer> arr = sequencedArrayCountingNumber(n);

        return makeIntArray(arr.stream());
    }


    public ArrayList<Integer> randomArray(int n, int range) {
        ArrayList<Integer> arr = new ArrayList<Integer>(n);

        int j = n;

        while (j-- > 0)
            arr.add(_random.nextInt(range));

        return arr;
    }

    public int[] randomArrayAsInt(int n, int range) {
        ArrayList<Integer> arr = randomArray(n, range);

        return makeIntArray(arr.stream());
    }

    public ArrayList<String> stringArray(int n, int size) {
        ArrayList<String> arr = new ArrayList<String>(n);

        int j = n;
        while (j-- > 0) {
            arr.add(UtilsString.randomStringAlpha(size));
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,4};

        System.out.println(Arrays.toString(arr));
    }

}

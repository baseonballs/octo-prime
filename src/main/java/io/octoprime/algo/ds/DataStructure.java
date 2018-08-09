package io.octoprime.algo.ds;

import java.util.*;

public class DataStructure {

    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    private static Random _random = new Random();

    public static int[] getRandomArray(int size, int range) {
        int[] arr = new int[size <= 0 ? 0 : size];

        for (int i = 0; i < size; i++) {
            arr[i] = _random.nextInt(range);
        }

        return arr;
    }

    public static ArrayList<Integer> getRandomArrayList(int size, int range) {
        ArrayList<Integer> arr = new ArrayList<Integer>(size <= 0 ? 0 : size);

        while (size-- > 0)
            arr.add(_random.nextInt(range));

        return arr;
    }

    public static void doIterations(List<Integer> list) {

        System.out.println("\n>>>");
        System.out.println("Test Case:");
        System.out.println(">>>");


        if (true) {
            System.out.println("Iteration [1]::for loop: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }

        if (true) {
            System.out.println("\nIteration [2]::while loop: ");

            int i = 0;
            while (i < list.size()) {
                System.out.print(list.get(i++) + " ");
            }

        }

        if (true) {
            System.out.println("\nIteration [3]::advance loop: ");

            for (Integer e : list) {
                System.out.print(e + " ");
            }
        }

        if (true) {
            System.out.println("\nIteration [4]::iterator loop: ");

            Iterator<Integer> iter = list.iterator();

            while (iter.hasNext())
                System.out.print(iter.next() + " ");
        }

        if (true) {
            System.out.println("\nIteration [5]::foreach loop: ");

            list.forEach((e) -> {
                System.out.print(e.toString() + " ");
            });
        }

        if (true) {
            System.out.println("\nIteration [6]::stream loop: ");

            list.stream().forEach((a) -> {
                System.out.print(a.toString() + " ");
            });
        }

        if (true) {
            System.out.println("\nIteration [7]::stream-func loop: ");

            list.stream().forEach(System.out::print);
        }

        if (true) {
            System.out.println("\nIteration [8]::conversion loop: ");

            // System.out.println(list);
            int[] arr = list.stream().mapToInt(x -> x).toArray();
            System.out.println("before::" + Arrays.toString(arr));

            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < (n - 2); j++) {
                    if (arr[j] > arr[j + 1]) {
                        int t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }
                }
            }

            System.out.println("after::" + Arrays.toString(arr));
        }

    }

    public static void main(String[] arr) {
        System.out.println("Random Array: ");
        System.out.println(Arrays.toString(getRandomArray(DEFAULT_SIZE, DEFAULT_RANGE)));

        System.out.println("Random ArrayList: ");
        List<Integer> l = null;

        System.out.println((l = getRandomArrayList(DEFAULT_SIZE, DEFAULT_RANGE)).toString());
        doIterations(l);
    }
}

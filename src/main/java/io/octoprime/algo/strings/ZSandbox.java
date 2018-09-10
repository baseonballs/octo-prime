package io.octoprime.algo.strings;

import java.util.*;

public class ZSandbox {


    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void insertion(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = temp;
        }
    }

    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            int t = arr[min];
            arr[min] = arr[i];
            arr[i] = t;
        }
    }

    public static int bsearch(int[] arr, int start, int end, int value) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == value)
                return mid;

            if (value < arr[mid])
                return bsearch(arr, start, mid - 1, value);
            else
                return bsearch(arr, mid + 1, end, value);
        }

        return -1;

    }

    public static int[] unionNaive(int[] a, int[] b) {
        Set<Integer> list = new LinkedHashSet<>();

        for (int e : a)
            list.add(e);

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++)
                if (a[i] != b[j])
                    list.add(b[j]);

        return list.stream().mapToInt(e -> e).toArray();
    }

    public static int[] union(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();

        int asize = a.length;
        int bsize = b.length;

        if (bsize > asize) {
            int[] t = a;
            a = b;
            b = t;

            asize = a.length;
            bsize = b.length;
        }

        Arrays.sort(a);

        for (int e : a)
            list.add(e);
        for (int i = 0; i < b.length; i++) {
            if (bsearch(a, 0, a.length - 1, b[i]) == -1)
                list.add(b[i]);
        }

        return list.stream().mapToInt(e -> e).toArray();
    }


    public static int[] intersection(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();

        int asize = a.length;
        int bsize = b.length;

        if (bsize > asize) {
            int[] t = a;
            a = b;
            b = t;

            asize = a.length;
            bsize = b.length;
        }

        Arrays.sort(a);

        for (int i = 0; i < b.length; i++) {
            if (bsearch(a, 0, a.length - 1, b[i]) != -1)
                list.add(b[i]);
        }

        return list.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        String a = "abc";

        System.out.println("input string  : " + a);
        int[] arr = new int[]{59, 3, 69, 21, 0, 34, 2, 90, 11};
        int[] b = new int[]{21, 19, 17, 3, 90, 33, 0};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(b));

        //   insertion(arr);
        //   System.out.println(Arrays.toString(arr));

        int[] iList = intersection(b, arr);
        int[] uList = union(b, arr);
        int[] nList = unionNaive(arr, b);

        System.out.println(Arrays.toString(iList));
        System.out.println(Arrays.toString(uList));
        System.out.println(Arrays.toString(nList));

        if (true) {
            int index = bsearch(arr, 0, arr.length - 1, 3);
            if (index == -1)
                System.out.println("Element not found.");
            else
                System.out.println("Element found.");
        }

    }
}

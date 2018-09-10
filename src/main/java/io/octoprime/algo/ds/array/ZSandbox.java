package io.octoprime.algo.ds.array;

import io.octoprime.utils.UtilsArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZSandbox {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int m = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[m]) m = j;
            }

            int t = arr[m];
            arr[m] = arr[i];
            arr[i] = t;
        }
    }


    int bsearch(int[] arr, int low, int high, int value) {

        if (low <= high) {
            int pivot = low + (high - low) / 2;

            if (value == arr[pivot]) return pivot;
            if (value < arr[pivot]) return bsearch(arr, low, pivot - 1, value);
            if (value > arr[pivot]) return bsearch(arr, pivot + 1, high, value);
        }

        return -1;
    }


    public static void doubleArray() {
        int[][] darr = new int[][]{{1, 2, 3}, {4, 5, 6}};

        int m = darr.length;
        int n = darr[0].length;

        System.out.println("array size: " + darr.length);
        System.out.println("array size: " + darr[0].length);
        for (int i = 0; i < darr.length; i++) {
            for (int j = 0; j < darr[0].length; j++) {
                System.out.print(darr[i][j] + ", ");
            }
            System.out.println();
        }
    }


    public static List<int[]> findPairs(int[] arr) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("[" + arr[i] + "," + arr[j] + "]");
                list.add(new int[]{arr[i], arr[j]});
            }
        }

        return list;
    }

    public static int findstr(String s, String t) {
        int tsize = t.length();
        int ssize = s.length();

        for (int i = 0; i < ssize - tsize + 1; i++) {
            int j = 0;
            for (; j < tsize; j++) {
                if (s.charAt(i + j) != t.charAt(j)) break;
            }
            if (j == tsize) return i;
        }

        return -1;
    }
    public static void main(String[] args) {

        int[] arrs1 = new int[]{58, 17, 3};

        int[] arrs = new int[]{39, 2, 18, 9, 1, 11, 99, 21, 15, 88};
        int[] arr = new UtilsArray().randomArrayAsInt(10, 100);


        if (false) {
            doubleArray();

            List<int[]> ll = findPairs(arrs1);
            System.out.print("size: " + ll.size());
            System.out.println(">>>>>>");

            for (int[] e : ll) {
                System.out.println(Arrays.toString(e));
            }
        }

        int index = findstr("Jeff Lucas", "Lucas");
        if (index == -1) System.out.println("String not found.");
        else
            System.out.println("String found!");

        if (false) {
            System.out.println(Arrays.toString(arrs));
            sort(arrs);
            System.out.println(Arrays.toString(arrs));

            int bIndex = new ZSandbox().bsearch(arrs, 0, arrs.length - 1, 2);

            System.out.println("index : " + bIndex);
            if (bIndex == -1)
                System.out.println("not found.");
            else
                System.out.println("Element found.");
        }
    }
}

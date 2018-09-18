package io.octoprime.algo.ds.array;

import java.util.*;

public class KSmallestPairsInSingleArray {


    public static List<int[]> findPairsSingleArray(int[] arr) {

        List<int[]> col = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                col.add(new int[]{arr[i], arr[j]});
            }
        }
        return col;
    }


    public static List<int[]> findSmallestPairs(int[] arr, int k) {
        List<int[]> l = findPairsSingleArray(arr);

        Collections.sort(l, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] + a[1]) - (b[0] + b[1]);
            }
        });

        int size = l.size() - 1;

        while (size-- >= k)
            l.remove(size);

        return l;
    }

    public static void main(String[] args) {

        int[] a = new int[]{5, 4, 3, 2, 1};

        System.out.println("a array: " + Arrays.toString(a));

        List<int[]> list = findSmallestPairs(a, 3);

        System.out.println(">>>> ");
        for (int[] e : list) {
            System.out.print(Arrays.toString(e) + ", ");
        }
        System.out.println();

    }
}

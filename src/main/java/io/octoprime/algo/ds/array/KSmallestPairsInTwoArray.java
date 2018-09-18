package io.octoprime.algo.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.octoprime.utils.UtilsArray.randomArrayAsInt;

public class KSmallestPairsInTwoArray {

    /**
     * You are given two integer arrays nums1 and b sorted in ascending order and an integer k.
     * <p>
     * Define a pair (u,v) which consists of one element from the first arr and one element from the second arr.
     * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
     * <p>
     * Given nums1 = [1,7,11], b = [2,4,6],  k = 3
     * Return: [1,2],[1,4],[1,6]
     * The first 3 pairs are returned from the sequence:
     * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     */
    public static List<int[]> findKSmallestPairs(int[] a, int[] b, int k) {
        List<int[]> result = new ArrayList<int[]>();

        if (k == 0)
            return result;

        int[] index = new int[a.length];

        while (k > 0) {
            int min = Integer.MAX_VALUE;
            int j = 0;
            for (int i = 0; i < a.length; i++) {
                if (index[i] < b.length && a[i] + b[index[i]] < min) {
                    min = a[i] + b[index[i]];
                    j = i;
                }
            }

            int[] arr = {a[j], b[index[j]]};
            result.add(arr);

            index[j]++;

            k--;
        }

        return result;
    }


    public static void main(String[] args) {


        int[] a = randomArrayAsInt(10, 100);
        int[] b = randomArrayAsInt(5, 100);
        int[] c = new int[]{5, 4, 3, 2, 1};

        System.out.println("a array: " + Arrays.toString(a));
        System.out.println("b array: " + Arrays.toString(a));
        System.out.println("c array: " + Arrays.toString(c));

        List<int[]> col = findKSmallestPairs(a, b, 10);

        if (true) {
            System.out.println(">>>> ");
            for (int[] e : col) {
                System.out.print(Arrays.toString(e) + ", ");
            }
            System.out.println();
        }

    }
}

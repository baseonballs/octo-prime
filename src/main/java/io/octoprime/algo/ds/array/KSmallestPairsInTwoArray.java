package io.octoprime.algo.ds.array;

import java.util.*;

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

    /**
     * Naive Method:
     *  a) find all the paris and store their sum. Running Time O(m * n) are the size of tha array a, b
     *  b) Sort the pairs according to the sum, O( m * n log( m * n ));
     */

    /**
     * Efficient Method:
     * Goal, find k smallest sum pairs, traversing the first array;
     * 1. keep track of all elements of second array which has already been considered for every element of first;
     * so that in an iteration we only consider the next element. The index[] is used to track the indexes of next
     * elements in the other array. It simply means that which element of second array to be added with the element
     * first array in each pass of the iteration. We increment value in the index array for the element that forms
     * next minimum value pairs.
     */
    public static List<int[]> findKSmallestPairs(int[] a, int[] b, int k) {
        List<int[]> list = new ArrayList<int[]>();

        if (k == 0)
            return list;

        int[] index = new int[a.length];

        while (k > 0) {
            int sum = Integer.MAX_VALUE;
            int j = 0;
            for (int i = 0; i < a.length; i++) {
                if (index[i] < b.length && a[i] + b[index[i]] < sum) {
                    sum = a[i] + b[index[i]];
                    j = i;
                }
            }

            int[] arr = {a[j], b[index[j]]};
            list.add(arr);

            index[j]++;

            k--;
        }

        return list;
    }


    public static List<int[]> naiveFindKSmallestPairsUnsortedArrays(int[] a, int[] b, int k) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int[] elem = {a[i], b[j]};
                list.add(elem);
            }
        }

        /**
         * sort the lists
         */
        Collections.sort(list, new Comparator<int[]>() {

                    public int compare(int[] e1, int[] e2) {
                        return (e1[0] + e1[0]) - (e2[0] + e2[0]);
                    }
                }
        );

        /**
         * find the k-pairs
         */
        int j = list.size();
        while (j-- > k) {
            list.remove(j);
        }

        return list;
    }

    public static List<int[]> naiveFindKSmallestPairsSortedArrays(int[] a, int[] b, int k) {
        List<int[]> list = new ArrayList<>();

        return list;
    }

    public static void printPairs(List<int[]> list) {
        System.out.println(">>>> ");
        int i = 0;
        for (int[] e : list) {
            System.out.print(Arrays.toString(e) + (i == list.size() - 1 ? "" : ", "));
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] A = {1, 7, 11};
        int[] B = {2, 4, 6};

        int[] unsortedA = randomArrayAsInt(5, 20);
        int[] unsortedB = randomArrayAsInt(8, 20);
        int[] c = new int[]{5, 4, 3, 2, 1};

        System.out.println("unsortedA array: " + Arrays.toString(unsortedA));
        System.out.println("unsortedB array: " + Arrays.toString(unsortedB));
        System.out.println("sorted c array: " + Arrays.toString(c));
        System.out.println("sorted A array: " + Arrays.toString(A));
        System.out.println("sorted B array: " + Arrays.toString(B));

        List<int[]> col = findKSmallestPairs(A, B, 3);
        System.out.println("[Sorted Array]");
        printPairs(col);

        List<int[]> naiveList = naiveFindKSmallestPairsUnsortedArrays(unsortedA, unsortedB, 2);
        System.out.println("[Unsorted Array]");
        printPairs(naiveList);
    }
}

package io.octoprime.algo.sort;

import java.util.Arrays;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;

public class CountingSort {


    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    void sort(int arr[], int aux[], int sortedA[], int N) {

        // First, find the maximum key in A[]
        int K = 0;
        for(int i=0; i<N; i++) {
            K = Math.max(K, arr[i]);
        }

        // Initialize the elements of Aux[] with 0
        for(int i=0 ; i<=K; i++) {
            aux[i] = 0;
        }

        // Store the frequencies of each distinct element of A[],
        // by mapping its key as the index of Aux[] array
        for(int i=0; i<N; i++) {
            aux[arr[i]]++;
        }

        int j = 0;
        for(int i=0; i<=K; i++) {
            int tmp = aux[i];
            // Aux stores which element occurs how many times,
            // Add i in sortedA[] according to the number of times i occured in A[]
            while( (tmp--) > 0) {
                //cout << Aux[i] << endl;
                sortedA[j] = i;
                j++;
            }
        }
    }


    public static void main(String[] arg) {
        CountingSort counting = new CountingSort();

        int[] numbers = getRandomArray(DEFAULT_SIZE, DEFAULT_RANGE);
        int[] aux = new int[ numbers.length];
        int[] sorted = new int[ numbers.length];

        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Sorted array: ");
        counting.sort(numbers,aux, sorted, numbers.length);
        System.out.println(Arrays.toString(sorted));
    }

}

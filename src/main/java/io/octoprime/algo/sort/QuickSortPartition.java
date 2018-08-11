package io.octoprime.algo.sort;

import java.util.Arrays;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;

/*
    Quick sort is based on the divide-and-conquer approach based on the idea of choosing one element as a pivot element
    and partitioning the array around it such that: Left side of pivot contains all the elements that are less than the
    pivot element Right side contains all elements greater than the pivot

    It reduces the space complexity and removes the use of the auxiliary array that is used in merge sort.
    Selecting a random pivot in an array results in an improved time complexity in most of the cases.

    Complexity: Best = O(n log n); worse = O(n^2), average = O(2N Log N)
 */
public class QuickSortPartition implements Sort {
    private static int DEFAULT_SIZE = 10;
    private static int DEFAULT_RANGE = 100;

    private int partition(int arr[], int start, int end) {

        int piv = arr[start];
        int i = start + 1;

        for (int j = start + 1; j <= end; j++) {

            /*
                rearrange the array by putting elements which are less than pivot
                on one side and which are greater that on other.
            */
            if (arr[j] < piv) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;

                i += 1;
            }
        }
        //put the pivot element in its proper place.
        int t = arr[start];
        arr[start] = arr[i - 1];
        arr[i - 1] = t;

        return i - 1; // return the position of the pivot
    }

    private void sort(int arr[], int start, int end) {
        if (start < end) {
            //stores the position of pivot element
            int piv_pos = partition(arr, start, end);
            sort(arr, start, piv_pos - 1);    //sorts the left side of pivot.
            sort(arr, piv_pos + 1, end); //sorts the right side of pivot.
        }
    }

    public void sort(int A[]) {
        sort(A, 0, A.length - 1);
    }

    public static void main(String[] arg) {
        QuickSortPartition quick = new QuickSortPartition();

        int[] numbers = getRandomArray(DEFAULT_SIZE, DEFAULT_RANGE);

        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Sorted array: ");
        quick.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}

package io.octoprime.algo.ds.array;

public class BinarySearchArray {

    /*
    Returns index of value if it is present in arr[start..end], else return -1
     */
    int bsearch(int arr[], int start, int end, int value) {
        if (end >= start) {
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

    public static void main(String args[]) {
        BinarySearchArray bs = new BinarySearchArray();
        int arr[] = {2, 3, 4, 10, 40};


        int result = bs.bsearch(arr, 0, arr.length - 1, 10);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}

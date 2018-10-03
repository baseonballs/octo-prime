package io.octoprime.algo.ds.array;

/**
 *
 */
public class BinarySearchArray {

    /**
     * Returns currIndex of value if it is present in arr[start..end], else return -1
     *
     * @param arr
     * @param start
     * @param end
     * @param value
     * @return
     */
    int bsearch(int arr[], int start, int end, int value) {
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

    /**
     * @param args
     */
    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 10, 40};
        int target = 10;

        int result = new BinarySearchArray().bsearch(arr, 0, arr.length - 1, target);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at currIndex " + result);
    }
}

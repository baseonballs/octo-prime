package io.octoprime.algo.ds.array;

import java.util.Arrays;
import java.util.Scanner;

public class Stats {


    /**
     * This method computes the mean of the values in the
     * input array.
     *
     * @param arr - an array of ints
     * @return mean - the mean of the input array
     */
    public static double mean(int[] arr) {
        int sum = 0;

        // Sum all values in our array
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        // Calculate mean
        double mean = ((double) sum) / ((double) arr.length);

        return mean;
    }


    /**
     * This method computes the median of the values in the
     * input array.
     *
     * @param arr - an array of ints
     * @return median - the median of the input array
     */
    public static double median(int[] arr) {

        // Sort our array
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        double median = 0;

        // If our array's length is even, then we need to find the average of the two centered values
        if (arr.length % 2 == 0) {
            int indexA = (arr.length - 1) / 2;
            int indexB = arr.length / 2;

            median = ((double) (sortedArr[indexA] + sortedArr[indexB])) / 2;
        }
        // Else if our array's length is odd, then we simply find the value at the center index
        else {
            int index = (sortedArr.length - 1) / 2;
            median = sortedArr[index];
        }

        // Print the values of the sorted array
        for (int v : sortedArr) {
            System.out.println(v);
        }

        return median;
    }

    /**
     * This method computes the mode of the values in the
     * input array.
     *
     * @param arr - an array of ints
     * @return mode - the mode of the input array
     */
    public static int mode(int[] arr) {

        int modeCount = 0;    // The count of the mode value
        int mode = 0;        // The value of the mode

        int currCount = 0;
        int currElement;

        // Iterate through all values in our array and consider it as a possible mode
        for (int candidateMode : arr) {
            // Reset the number of times we have seen the current value
            currCount = 0;

            // Iterate through the array counting the number of times we see the current candidate mode
            for (int element : arr) {
                // If they match, increment the current count
                if (candidateMode == element) {
                    currCount++;
                }
            }

            // We only save this candidate mode, if its count is greater than the current mode
            // we have stored in the "mode" variable
            if (currCount > modeCount) {
                modeCount = currCount;
                mode = candidateMode;
            }
        }

        return mode;
    }

    /**
     * Gets an int from user input
     *
     * @param scnr      - the Scanner object used for retrieving user input
     * @param promptMsg - the message to prompt user for an integer
     * @param errorMsg  - print this message in the even that the input is not an integer
     * @return the integer input by the user
     */
    private static int getInputInteger(Scanner scnr, String promptMsg, String errorMsg) {
        System.out.println(promptMsg);

        // Grab integer from user input
        while (!scnr.hasNextInt()) {
            System.out.print(errorMsg);
            scnr.nextLine();
        }
        int n = scnr.nextInt();

        return n;
    }

    /**
     * Gets an array of ints from the user of a specific size
     */
    private static int[] getInputArrayInts(Scanner scan, int arraySize) {
        // Create the array
        int[] values = new int[arraySize];

        // Input the numbers
        for (int i = 0; i < arraySize; i++) {
            String prompt = "Input the " + (i + 1) + "th number: ";
            String error = "Not an integer. Try again:";
            values[i] = getInputInteger(scan, prompt, error);
        }

        return values;
    }


    public static void main(String[] args) {
        // Create a Scanner object for retrieving user input
        Scanner scan = new Scanner(System.in);

        // Get number of numbers to include in our array from the user
        String userPrompt = "How many numbers will you input?";
        String invalidMsg = "Not an integer. Try again:";
        int arraySize = getInputInteger(scan, userPrompt, invalidMsg);

        // Get array input from the user
        int[] values = getInputArrayInts(scan, arraySize);

        // Calculate mean, median, and mode
        double mean = mean(values);
        double median = median(values);
        int mode = mode(values);

        // Print results
        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Mode: " + mode);

    }
}

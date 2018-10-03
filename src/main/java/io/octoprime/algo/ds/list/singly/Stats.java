package io.octoprime.algo.ds.list.singly;

import java.util.Scanner;

public class Stats {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // read in numbers
        Bag<Double> nums = new Bag<Double>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a value:");
            double value = scanner.nextDouble();
            nums.add(value);
        }

        /**
         * compute the mean.
         */
        double sum = 0.0;
        for (double x : nums)
            sum += x;
        double mean = sum / nums.size();

        /**
         * compute the standard deviation
         */
        sum = 0.0;
        for (double x : nums) {
            sum += (x - mean) * (x - mean);
        }
        double stddev = Math.sqrt(sum / (nums.size() - 1));

        System.out.printf("Mean:    %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", stddev);
    }
}

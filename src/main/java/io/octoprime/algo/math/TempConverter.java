package io.octoprime.algo.math;

import java.util.Scanner;

public class TempConverter {

    public static void main(String args[]) {
        float cen;
        double fh;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Temperature in Centigrade : ");
        cen = scanner.nextFloat();

        fh = (1.8 * cen) + 32;

        System.out.print("Equivalent Temperature in Fahrenheit = " + fh);
    }
}

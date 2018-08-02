package io.octoprime.algo;

import java.util.Arrays;
import java.util.Comparator;

public class Temper {
    public static void main(String[] arg) {
        int n = 10, m = 10;

        int[][] x = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                x[i][j] = -1;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(x[i][j] + ", ");
            System.out.println();
        }

        String[] months = {"February","March","April","May","June","July","August","September","October","December","January"};

        System.out.println(Arrays.toString(months)); //printing before


        Arrays.sort(months, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(months));

    }
}

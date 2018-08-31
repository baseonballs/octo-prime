package io.octoprime.algo.math.num;


/**
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11 ).
 */
public class Triangle {

    public int minimumTotal(int[][] triangle) {
        int lenX = triangle.length;
        int[][] sum = new int[lenX][lenX];
        sum[0][0] = triangle[0][0];
        for (int i = 1; i < lenX; i++) {
            for (int j = 0; j < (i + 1); j++) {
                if (j == 0) {
                    sum[i][j] = triangle[i][j] + sum[i - 1][j];
                } else if (j == i) {
                    sum[i][j] = triangle[i][j] + sum[i - 1][j - 1
                            ];
                } else {
                    sum[i][j] = triangle[i][j] + Math.min(sum[i -
                            1][j], sum[i - 1][j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < lenX; j++) {
            min = Math.min(min, sum[lenX - 1][j]);
        }
        return min;
    }
}

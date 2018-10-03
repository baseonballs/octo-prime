package io.octoprime.ps.fb.hard;

public class MaximumRectangle {

    public int maxRect(char[][] matrix) {
        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    maxSize = Math.max(rectSize(matrix, i, j), maxSize);
                }
            }
        }

        return maxSize;
    }

    private int rectSize(char[][] matrix, int row, int col) {
        int maxSize, rowSize, size;
        int i = row + 1, j = col + 1;
        maxSize = rowSize = size = 1;

        while (i < matrix.length && matrix[i++][col] == '1') {
            rowSize++;
        }

        maxSize = size = rowSize;

        while (j < matrix[0].length) {
            if (matrix[row][j] == '0') {
                break;
            }

            for (int k = row; k < row + rowSize; k++) {
                if (matrix[k][j] == '0') { //if a '0' is found, reshape the rectangle
                    int oldrowSize = rowSize;
                    rowSize = k - row;
                    size -= (j - col) * (oldrowSize - rowSize);
                }
            }

            size += rowSize;
            maxSize = Math.max(maxSize, size);
            j++;
        }

        return maxSize;
    }
}

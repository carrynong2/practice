package leetcode.bind75.matrix;

import java.util.Arrays;

public class SetMatrixZero {
    static void main() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if (copy[i][j] == 0) {
                    for (int k = 0; k < copy[0].length; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < copy.length; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}

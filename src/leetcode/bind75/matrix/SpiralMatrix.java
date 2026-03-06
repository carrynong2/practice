package leetcode.bind75.matrix;

import java.util.List;

public class SpiralMatrix {
    static void main() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int row = 0, col = 0;
        List<Integer> result = new java.util.ArrayList<>();
        int totalElements = matrix.length * matrix[0].length;
        for (int i = 0; i < totalElements; i++) {
            result.add(matrix[row][col]);
            matrix[row][col] = Integer.MIN_VALUE; // Mark as visited
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0
                    || nextCol >= matrix[0].length ||
                    matrix[nextRow][nextCol] == Integer.MIN_VALUE) {
                directionIndex = (directionIndex + 1) % 4; // Change direction
                nextRow = row + directions[directionIndex][0];
                nextCol = col + directions[directionIndex][1];
            }
            row = nextRow;
            col = nextCol;
        }
        return result;
    }
}

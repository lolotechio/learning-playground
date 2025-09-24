package io.lolotech.udemy.twoDArrays;

import java.util.LinkedList;
import java.util.List;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println("Number of islands: " + numberOfIslands(matrix));
    }

    private static int numberOfIslands(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int islands = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    islands++;
                    matrix[i][j] = 0; //mark as visited
                    bfs(matrix, i, j);
                }
            }
        }

        return islands;
    }

    private static void bfs(int[][] matrix, int row, int col) {
        List<RowCol> queue = new LinkedList<>();
        queue.add(new RowCol(row, col));

        int[][] directions = {
                {-1, 0}, // up
                {0, 1},  // right
                {1, 0},  // down
                {0, -1}  // left
        };

        while (!queue.isEmpty()) {
            var currentElement = queue.removeFirst();
            var currentRow = currentElement.row();
            var currentCol = currentElement.col();


            for (var direction : directions) {
                var nextRow = currentRow + direction[0];
                var nextCol = currentCol + direction[1];
                if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) {
                    continue;
                }

                if (matrix[nextRow][nextCol] == 1) {
                    queue.add(new RowCol(nextRow, nextCol));
                    matrix[nextRow][nextCol] = 0; //mark as visited
                }
            }
        }
    }

    record RowCol(int row, int col) {
    }

}

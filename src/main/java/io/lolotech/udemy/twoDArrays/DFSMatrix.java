package io.lolotech.udemy.twoDArrays;

import java.util.ArrayList;
import java.util.List;

public class DFSMatrix {

    //DFS in a 2D matrix
    //Order of traversal: up, right, down, left

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> values = new ArrayList<>();
        dfs(matrix, 0, 0, visited, values);

        System.out.println("DFS Traversal of the matrix:");
        System.out.println(values);
    }

    private static void dfs(int[][] matrix, int row, int col, boolean[][] visited, List<Integer> values) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        values.add(matrix[row][col]);

        dfs(matrix, row - 1, col, visited, values); // up
        dfs(matrix, row, col + 1, visited, values); // right
        dfs(matrix, row + 1, col, visited, values); // down
        dfs(matrix, row, col - 1, visited, values); // left
    }
}

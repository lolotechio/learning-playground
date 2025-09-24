package io.lolotech.udemy.twoDArrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSMatrix {

    //DFS in a 2D matrix
    //Order of traversal: up, right, down, left
    //1, 2, 3, 4, 5
    //6, 7, 8, 9, 10
    //11,12,13,14,15
    //16,17,18,19,20
    //Output: [13, 8, 14, 18, 12, 3, 9, 7, 15, 19, 17, 11, 4, 2, 10, 6, 20, 16, 5, 1]

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };


        List<Integer> values = bfs(matrix);

        System.out.println("BFS Traversal of the matrix:");
        System.out.println(values);
        System.out.println(values.size());

        //BFS Recursive
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        LinkedList<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(matrix.length / 2, matrix[0].length / 2));
        List<Integer> valuesRecursive = new ArrayList<>();
        bfsRecursive(matrix, visited, queue, valuesRecursive);
        System.out.println("BFS Recursive Traversal of the matrix:");
        System.out.println(valuesRecursive);
        System.out.println(valuesRecursive.size());
    }

    private static List<Integer> bfs(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(matrix.length / 2, matrix[0].length / 2));
        List<Integer> values = new ArrayList<>();

        while (!queue.isEmpty()) {
            var start = queue.removeFirst();
            int row = start.row;
            int col = start.col;
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            values.add(matrix[row][col]);

            queue.add(new Coordinate(row - 1, col)); //up
            queue.add(new Coordinate(row, col + 1)); //right
            queue.add(new Coordinate(row + 1, col)); //down
            queue.add(new Coordinate(row, col - 1)); //left

        }

        return values;
    }

    private static void bfsRecursive(int[][] matrix, boolean[][] visited, LinkedList<Coordinate> queue, List<Integer> values) {
        if (queue.isEmpty()) {
            return;
        }

        var start = queue.removeFirst();
        int row = start.row;
        int col = start.col;
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col]) {
            bfsRecursive(matrix, visited, queue, values);
            return;
        }

        visited[row][col] = true;
        values.add(matrix[row][col]);

        queue.add(new Coordinate(row - 1, col)); //up
        queue.add(new Coordinate(row, col + 1)); //right
        queue.add(new Coordinate(row + 1, col)); //down
        queue.add(new Coordinate(row, col - 1)); //left

        bfsRecursive(matrix, visited, queue, values);
    }

    static class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

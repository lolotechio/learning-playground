package io.lolotech.udemy.twoDArrays;

import java.util.Arrays;

public class MinimumPathSum {

//    You are given an m x n grid filled with non-negative numbers.
//    A path starts at the top-left corner and ends at the bottom-right corner.
//    At each step, you can only move down or right.
//    Your task is to find the minimum path sum from top-left to bottom-right.
//
//     2 1 1 4 0
//     0 3 5 7 8
//     2 4 7 9 1
//     0 0 2 3 1
//     9 7 4 6 5

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 1, 4, 0},
                {0, 3, 5, 7, 8},
                {2, 4, 7, 9, 1},
                {0, 0, 2, 3, 1},
                {9, 7, 4, 6, 5}
        };

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        int minPathSum = minPathSum(matrix, matrix.length - 1, matrix[0].length - 1, dp);
        System.out.println("Min Path SUM = " + minPathSum);
    }

    // Top-Down Approach with Memoization
    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n) for the dp array + O(m + n) for the recursion stack
    static int minPathSum(int[][] matrix, int row, int col, int[][] dp) {
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }

        if (row == 0 && col == 0) {
            return matrix[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = matrix[row][col] + Math.min(minPathSum(matrix, row-1, col, dp), minPathSum(matrix, row, col - 1, dp));

        return dp[row][col];
    }

}

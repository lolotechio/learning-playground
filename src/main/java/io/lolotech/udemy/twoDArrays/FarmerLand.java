package io.lolotech.udemy.twoDArrays;

public class FarmerLand {

    // A farmer wants to farm their land with the maximum area where good land is present.
    // The and is represented as a matrix with 1s and 0s where 1 represents good land and 0 represents bad land.
    // The farmer only wants to farm in a square of good land with the maximum area.
    // Please help the farmer to find the maximum area of the land they can farm in good land.

    //Example:
    // 0 1 1 0 1
    // 1 1 0 1 0
    // 0 1 1 1 0
    // 1 1 1 1 0
    // 1 1 1 1 1
    // 0 0 0 0 0
    //Output: 9

    public static void main(String[] args) {
        int[][] land = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        System.out.println("Maximum farmable area: " + largestSquare(land));
        System.out.println("Maximum farmable area - BRUTE FORCE: " + largestSquareBruteForce(land));
    }

    //O(n*m) time | O(n*m) space
    private static int largestSquare(int[][] binArray) {
        int n = binArray.length;
        int m = binArray[0].length;

        int[][] dp = new int[n][m];
        int maxNum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (binArray[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int left = (i > 0) ? dp[i - 1][j] : 0;
                    int up = (j > 0) ? dp[i][j - 1] : 0;
                    int diag = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;

                    dp[i][j] = Math.min(Math.min(left, up), diag) + 1;
                    maxNum = Math.max(maxNum, dp[i][j]);
                }
            }
        }

        // Return area of the largest square
        return maxNum * maxNum;
    }

    //O(n^3) time | O(1) space
    private static int largestSquareBruteForce(int[][] binArray) {
        int n = binArray.length;
        int m = binArray[0].length;

        int maxNum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (binArray[i][j] == 1) {
                    int currentMax = findMaxSquareFromPosition(binArray, i, j);
                    maxNum = Math.max(maxNum, currentMax);
                }
            }
        }

        // Return area of the largest square
        return maxNum * maxNum;
    }

    private static int findMaxSquareFromPosition(int[][] binArray, int row, int col) {
        int maxSize = 0;
        int n = binArray.length;
        int m = binArray[0].length;

        boolean canExpand = true;
        while (canExpand && row + maxSize < n && col + maxSize < m) {
            // Check the new row
            for (int j = col; j <= col + maxSize; j++) {
                if (binArray[row + maxSize][j] == 0) {
                    canExpand = false;
                    break;
                }
            }

            // Check the new column
            for (int i = row; i <= row + maxSize; i++) {
                if (binArray[i][col + maxSize] == 0) {
                    canExpand = false;
                    break;
                }
            }

            if (canExpand) {
                maxSize++;
            }
        }

        return maxSize;
    }
}

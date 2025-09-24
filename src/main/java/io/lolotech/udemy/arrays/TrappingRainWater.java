package io.lolotech.udemy.arrays;

public class TrappingRainWater {

    // https://leetcode.com/problems/trapping-rain-water/description/
    // Given an array of integers representing an elevation map where the width of each bar is 1,
    // compute how much water it can trap after raining.

    //Example
    // Input: height = [0,1,0,2,1,0,3,1,0,1,2]
    // Output: 8
    // Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,3,1,0,1,2].
    // In this case, 8 units of rain water (blue section) are being trapped.

    //currentWaterLevel = min(maxLeft, maxRight) - height[i]

    public static void main(String[] args) {
        System.out.println(trappingWater(new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2}));
        System.out.println(trappingWater(new int[]{5, 0, 3, 0, 0, 0, 2, 3, 4, 2, 1}));
        System.out.println(trappingWaterOptimized(new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2}));
        System.out.println(trappingWaterOptimized(new int[]{5, 0, 3, 0, 0, 0, 2, 3, 4, 2, 1}));
    }

    //O(n) time and O(1) space
    private static int trappingWaterOptimized(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;

        while (left < right) {
            if (heights[left] <= heights[right]) {
                if (maxLeft <= heights[left]) {
                    maxLeft = heights[left];
                } else {
                    totalWater += maxLeft - heights[left];
                }
                left ++;
            } else {
                if (maxRight <= heights[right]) {
                    maxRight = heights[right];
                } else {
                    totalWater += maxRight - heights[right];
                }
                right --;
            }
        }

        return totalWater;
    }

    //O(n^2) time and O(1) space
    private static int trappingWater(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int totalWater = 0;

        for (int i = 0; i < heights.length; i++) {
            int maxLeft = 0;
            int maxRight = 0;

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] > maxRight) {
                    maxRight = heights[j];
                }
            }

            for (int k = i - 1; k >= 0; k--) {
                if (heights[k] > maxLeft) {
                    maxLeft = heights[k];
                }
            }

            int currentWater = Math.min(maxLeft, maxRight) - heights[i];
            if (currentWater > 0) {
                totalWater += currentWater;
            }
        }

        return totalWater;
    }

}

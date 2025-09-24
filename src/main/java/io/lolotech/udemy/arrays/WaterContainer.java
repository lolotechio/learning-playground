package io.lolotech.udemy.arrays;

public class WaterContainer {

    //You are given an array of positive integers where each integer represents the height of a vertical line drawn on a chart.
    //Find two lines, which together with the x-axis forms a container that would hold the greatest amount of water.
    //Return the area of water it would hold

    //Example:
    //Input: [1,8,6,2,5,4,8,3,7]
    //Output: 49
    //Explanation: The vertical lines are represented by the array [1,8,6,2,5,4,8,3,7].
    //In this case, the lines at index 1 and index 8 form the container that holds the most water, with an area of 49.

    public static void main(String[] args) {
        System.out.println(waterContainer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(waterContainer(new int[]{6, 9, 3, 4, 5, 8}));
        System.out.println(waterContainer(new int[]{7, 1, 2, 3, 9}));
        System.out.println(waterContainer(new int[]{}));
        System.out.println(waterContainer(new int[]{7}));
    }

    private static int waterContainer(int[] heights) {
        if (heights.length < 2) return 0;
        int left = 0, right = heights.length - 1;
        int maxArea = 0;

        while (left <= right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

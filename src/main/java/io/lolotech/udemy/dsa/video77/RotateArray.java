package io.lolotech.udemy.dsa.video77;

import java.util.Arrays;

public class RotateArray {

//    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//    Example 1:
//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//    Example 2:
//    Input: nums = [-1,-100,3,99], k = 2
//    Output: [3,99,-1,-100]
//    Explanation:
//    rotate 1 steps to the right: [99,-1,-100,3]
//    rotate 2 steps to the right: [3,99,-1,-100]

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray(new int[]{-1, -100, 3, 99}, 2)));
        System.out.println(Arrays.toString(rotateArray(new int[]{-1}, 1)));

        System.out.println(Arrays.toString(rotateArray2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray2(new int[]{-1, -100, 3, 99}, 2)));
        System.out.println(Arrays.toString(rotateArray2(new int[]{-1}, 1)));

        System.out.println(Arrays.toString(rotateArray3(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray3(new int[]{-1, -100, 3, 99}, 2)));
        System.out.println(Arrays.toString(rotateArray3(new int[]{-1}, 1)));
    }

    //Big O (Time complexity) - O(n)
    //Space complexity: O(n)
    private static int[] rotateArray(int[] nums, int steps) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i < steps) {
                result[i] = nums[nums.length - steps + i];
            } else {
                result[i] = nums[i - steps];
            }
        }

        return result;
    }

    //Big O (Time complexity) - O(n)
    //Space complexity: O(n). We use another array of the same size to store the rotation.
    //Credit: Baeldung
    private static int[] rotateArray2(int[] nums, int steps) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[(i + steps) % nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);

        return result;
    }

    //Big O (Time complexity) - O(n)
    //Space complexity: O(1). Constant extra space is used.
    //Credit: Baeldung
    private static int[] rotateArray3(int[] nums, int steps) {
        steps = steps % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + steps) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }

        return nums;
    }

}

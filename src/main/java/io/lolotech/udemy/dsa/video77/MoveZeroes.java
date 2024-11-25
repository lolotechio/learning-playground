package io.lolotech.udemy.dsa.video77;

import java.util.Arrays;

public class MoveZeroes {

//    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//    Note that you must do this in-place without making a copy of the array.
//
//    Example 1://
//    Input: nums = [0,1,0,3,12]
//    Output: [1,3,12,0,0]
//
//    Example 2:
//    Input: nums = [0]
//    Output: [0]

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{0})));
    }

    //Big O (Time complexity) - O(n)
    private static int[] moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        int backwardIndex = nums.length - 1;

        for (int num : nums) {
            if (num == 0) {
                result[backwardIndex] = 0;
                backwardIndex--;
            } else {
                result[index] = num;
                index++;
            }
        }

        return result;
    }
}

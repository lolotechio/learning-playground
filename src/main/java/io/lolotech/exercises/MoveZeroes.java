package io.lolotech.exercises;

import java.util.Arrays;

public class MoveZeroes {

    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{0})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 0, 0, 2, 3, 0, 0, 12, 15, 7, 0, 3, 0, 5, 0, 0})));
    }

    //TC: O(n)
    private static int[] moveZeroes(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return array;
        }

        int left = 0;
        for (int right = 1; right < array.length; right++) {
            if (array[left] != 0) {
                swap(array, left, right);
            }
            if (array[right] != 0) {
                swap(array, left, right);
                left++;
            }
        }

        return array;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

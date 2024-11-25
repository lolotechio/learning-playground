package io.lolotech.udemy.dsa.video77;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumFromArray {

//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//    You can return the answer in any order.
//
//    Example 1:
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//    Example 2:
//    Input: nums = [3,2,4], target = 6
//    Output: [1,2]
//
//    Example 3:
//    Input: nums = [3,3], target = 6
//    Output: [0,1]
//
//    Constraints:
//    2 <= nums.length <= 10^4
//    -10^9 <= nums[i] <= 10^9
//    -10^9 <= target <= 10^9
//    Only one valid answer exists.

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumFromArray(new int[]{2, 7, 11, 15}, 22)));
        System.out.println(Arrays.toString(twoSumFromArray(new int[]{3, 2, 4}, 7)));
        System.out.println(Arrays.toString(twoSumFromArray(new int[]{3, 3}, 6)));

        System.out.println(Arrays.toString(twoSumFromArray2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumFromArray2(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSumFromArray2(new int[]{3, 3}, 6)));
    }

    //Big O (Time complexity) - O(n^2)
    private static int[] twoSumFromArray(int[] nums, int target) {
        if (invalidInput(nums) || invalidInput(target)) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (invalidInput(nums[i]) || invalidInput(nums[j])) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    //Big O (Time complexity) - O(n)
    private static int[] twoSumFromArray2(int[] nums, int target) {
        if (invalidInput(nums) || invalidInput(target)) {
            return null;
        }

        Map<Integer, Integer> pairWithIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (invalidInput(nums[i])) {
                continue;
            }

            int pair = target - nums[i];
            if (pairWithIndexMap.get(pair) != null) {
                return new int[]{pairWithIndexMap.get(pair), i};
            }

            pairWithIndexMap.put(nums[i], i);
        }

        return null;
    }

    private static boolean invalidInput(int[] nums) {
        return nums == null || nums.length < 2 || nums.length > Math.pow(10, 4);
    }

    private static boolean invalidInput(int number) {
        return number < Math.pow(-10, 9) || number > Math.pow(10, 9);
    }
}

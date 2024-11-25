package io.lolotech.udemy.dsa.video77;

public class MaximumSubarray {

//    Given an integer array nums, find the subarray with the largest sum, and return its sum.
//
//    Example 1:
//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//
//    Example 2:
//    Input: nums = [1]
//    Output: 1
//    Explanation: The subarray [1] has the largest sum 1.
//
//    Example 3://
//    Input: nums = [5,4,-1,7,8]
//    Output: 23
//    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    -10^4 <= nums[i] <= 10^4

    public static void main(String[] args) {
        System.out.println(maximumSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray(new int[]{1}));
        System.out.println(maximumSubarray(new int[]{5, 4, -1, 7, 8}));

        System.out.println(maximumSubarray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray2(new int[]{1}));
        System.out.println(maximumSubarray2(new int[]{5, 4, -1, 7, 8}));
    }

    //Big O (Time complexity) - O(n^2)
    private static int maximumSubarray(int[] nums) {
        if (invalidInput(nums)) {
            return Integer.MIN_VALUE;
        }

        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    //Big O (Time complexity) - O(n)
    private static int maximumSubarray2(int[] nums) {
        if (invalidInput(nums)) {
            return Integer.MIN_VALUE;
        }

        int[] sumsArray = new int[nums.length];
        sumsArray[0] = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int sum = sumsArray[i - 1] + nums[i];

            if (sum > nums[i]) {
                sumsArray[i] = sum;
                maxSum = Math.max(sum, maxSum);
            } else {
                sumsArray[i] = nums[i];
                maxSum = Math.max(sum, nums[i]);
            }
        }

        return maxSum;
    }

    private static boolean invalidInput(int[] nums) {
        return nums == null || nums.length < 1 || nums.length > Math.pow(10, 5);
    }
}

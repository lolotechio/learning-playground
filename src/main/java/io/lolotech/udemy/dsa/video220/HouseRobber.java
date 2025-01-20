package io.lolotech.udemy.dsa.video220;

public class HouseRobber {

    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
    it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

    Example 2:
    Input: nums = [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    Total amount you can rob = 2 + 9 + 1 = 12.
    */
    //P(k)=max(P(k-2)+M(K),P(k-1),M(k)+M(K+2))
    public static void main(String[] args) {
        System.out.println(topAmountToRob(new int[]{1, 2, 3, 1}));
        System.out.println(topAmountToRob(new int[]{5, 2, 7, 9, 3, 1}));
        System.out.println(topAmountToRob(new int[]{4, 1, 1, 4}));
    }

    private static int topAmountToRob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // The last element in dp contains the maximum amount that can be robbed
        return dp[n - 1];
    }
}

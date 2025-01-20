package io.lolotech.udemy.dsa.video220;

/*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // Output: 2
        System.out.println(climbStairs(3)); // Output: 3
        System.out.println(climbStairs(5)); // Output: 8
    }

    //Time complexity: O(n)
    //Space complexity: O(n) (the dp array)
    public static int climbStairs(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //Time complexity: O(n)
    //Space complexity: O(1) (the two variables)
    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int prev1 = 2; // Represents f(n-1)
        int prev2 = 1; // Represents f(n-2)

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

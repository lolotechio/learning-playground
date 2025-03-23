package io.lolotech.exercises;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    /*
    Write an algorithm to determine if a number n is happy.
    A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.

    Example 1:
    Input: n = 19
    Output: true
    Explanation:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 02 = 1

    Example 2:

    Input: n = 2
    Output: false
     */

    public static void main(String[] args) {
        System.out.println((isHappy(19)));
        System.out.println((isHappy(2)));
    }

    //We keep track of previously seen numbers. If a number repeats, we’re in a cycle.
    //Time Complexity: O(log n) digits per number, and cycle length is bounded → effectively O(1).
    //Space Complexity: O(log n) space for digits, but main space is for HashSet, which is bounded (because the cycle happens in a small range of values).
    private static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }

        return n == 1;
    }

    private static int sumOfSquares(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}

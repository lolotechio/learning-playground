package io.lolotech.exercises;

import java.util.Arrays;

public class MissingNumber {

    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    Example 1:
    Input: nums = [3,0,1]
    Output: 2
    Explanation:
    n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

    Example 2:
    Input: nums = [0,1]
    Output: 2
    Explanation:
    n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

    Example 3:
    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation:
    n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
     */

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingNumber2(new int[]{3, 0, 1}));
        System.out.println(missingNumber2(new int[]{0, 1}));
        System.out.println(missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    // TC: O(n log n); Arrays.sort(array) uses QuickSort (for primitive types like int[]), which has an average and worst-case complexity of O(n log n)
    // SC: O(1); Arrays.sort(array) for primitive types like int[] is O(1) since it sorts in place (does not create extra copies).
    private static int missingNumber(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i <= array.length; i++) {
            if (i == array.length) {
                return i;
            }

            if (i != array[i]) {
                return i;
            }
        }

        return -1;
    }

    // TC: O(n)
    // SC: O(1)
    private static int missingNumber2(int[] array) {
        int n = array.length;
        int expectedSum = n * (n + 1) / 2; //mathematical formula for the sum of first N natural numbers;
        int actualSum = 0;

        for (int number : array) {
            actualSum += number;
        }

        if (expectedSum == actualSum) {
            return -1;
        }

        return expectedSum - actualSum;
    }
}

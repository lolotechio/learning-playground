package io.lolotech.exercises;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: true
    Explanation:
    The element 1 occurs at the indices 0 and 3.

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false
    Explanation:
    All elements are distinct.

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true
     */

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    //TC O(n)
    private static boolean containsDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return false;
            }
        }

        return true;
    }
}

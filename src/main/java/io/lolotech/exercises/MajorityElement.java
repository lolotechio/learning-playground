package io.lolotech.exercises;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /*
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:
    Input: nums = [3,2,3]
    Output: 3

    Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2
     */

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 3, 4, 5, 1, 1, 1, 2, 2}));
    }

    //TC O(n)
    //SC O(1)
    //Boyer-Moore's Voting Algorithm
    private static int majorityElement(int[] array) {
        int candidate = 0, count = 0;

        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    //TC O(n)
    //SC O(n)
    private static int majorityElement2(int[] array) {
        Map<Integer, Integer> numberAppearance = new HashMap<>();

        for (int number : array) {
            numberAppearance.merge(number, 1, Integer::sum);
        }

        int max = Collections.max(numberAppearance.values());

        return numberAppearance.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(0);
    }
}

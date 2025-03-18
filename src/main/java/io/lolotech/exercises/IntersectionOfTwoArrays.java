package io.lolotech.exercises;

import java.util.*;

public class IntersectionOfTwoArrays {

    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    //TC: O(n+m)
    //SC: O(min(n, m))
    private static int[] intersect(int[] array1, int[] array2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int number1 : array1) {
            countMap.put(number1, countMap.getOrDefault(number1, 0) + 1);
        }

        for (int number2 : array2) {
            if (countMap.getOrDefault(number2, 0) > 0) {
                resultList.add(number2);
                countMap.put(number2, countMap.get(number2) - 1);
            }
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}

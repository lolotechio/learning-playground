package io.lolotech.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4

    Example 3:
    Input: nums = [1]
    Output: 1
     */

    public static void main(String[] args) {
        System.out.println(singleNumber3(new int[]{2, 2, 1}));
        System.out.println(singleNumber3(new int[]{4, 1, 2, 1, 2, 3, 5, 7, 7, 3, 4}));
        System.out.println(singleNumber3(new int[]{1}));
    }

    //Time complexity O(n)
    //Space complexity O(n)
    private static int singleNumber(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return array[0];
        }

        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int number : array) {
            numberCount.merge(number, 1, Integer::sum);
        }

        var mapEntry = numberCount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst();

        if (mapEntry.isPresent()) {
            return mapEntry.get().getKey();
        } else {
            return -1;
        }
    }

    //Time complexity O(n log n) - Sorting an array typically takes O(n log n)
    //Space complexity O(log n) - The space complexity of Arrays.sort is O(log n) in the case of the default Dual-Pivot Quicksort algorithm, which is used by the Java Arrays.sort()
    private static int singleNumber2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return array[0];
        }

        Arrays.sort(array);
        int single = array[0];
        for (int i = 1; i < array.length; i++) {
            if (single == array[i]) {
                single = -1;
            } else if (single == -1) {
                single = array[i];
            }
        }

        return single;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //a ^ a = 0 (any number XORed with itself results in 0)
    //a ^ 0 = a (any number XORed with 0 results in the number itself)
    //XOR is commutative and associative, meaning the order of operations does not matter
    private static int singleNumber3(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int result = 0;
        for (int number : array) {
            result ^= number;
        }

        return result;
    }
}

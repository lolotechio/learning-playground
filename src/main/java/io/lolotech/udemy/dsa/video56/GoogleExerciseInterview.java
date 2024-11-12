package io.lolotech.udemy.dsa.video56;

import java.util.HashMap;
import java.util.Map;

public class GoogleExerciseInterview {

    //Given a collection of numbers and a sum, find the matching pair from the collection that is equal to the sum
    //Example
    //[1, 2, 3, 9], Sum = 8 -> No matching pair
    //[1, 2, 4, 40, Sum = 8 -> Yes => 4 + 4 = 8

    public static void main(String[] args) {
        printResult(findMatchingPairForSum(new int[]{1, 2, 3, 9}, 8), 8);
        printResult(findMatchingPairForSum(new int[]{1, 2, 4, 4}, 8), 8);
    }

    private static void printResult(int[] result, int sum) {
        if (result == null) {
            System.out.printf("No matching pair that equals %d%n", sum);
        } else {
            System.out.printf("The matching pair that equals %d is [%d, %d]", sum, result[0], result[1]);
        }
    }

    //Big O (Time complexity) - O(n^2)
    private static int[] findMatchingPairForSum(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || ((array[i] + array[j]) != sum)) {
                    continue;
                }

                return new int[]{array[i], array[j]};
            }
        }

        return null;
    }

    private static int[] findMatchingPairForSum(int[] array, int sum) {
        Map<Integer, Integer> mapWithPossiblePairs = new HashMap<>();
        for (int value : array) {
            mapWithPossiblePairs.put(value, sum - value);
        }

        for (int value : array) {

        }
    }
}

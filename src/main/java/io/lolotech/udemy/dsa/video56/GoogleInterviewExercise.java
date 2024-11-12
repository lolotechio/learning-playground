package io.lolotech.udemy.dsa.video56;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoogleInterviewExercise {

    //Given a collection of numbers and a sum, find the matching pair from the collection that is equal to the sum
    //Example
    //[1, 2, 3, 9], Sum = 8 -> No matching pair
    //[1, 2, 4, 40, Sum = 8 -> Yes => 4 + 4 = 8

    public static void main(String[] args) {
        //printResult(findMatchingPairForSum(new int[]{1, 2, 3, 9}, 8), 8);
        //printResult(findMatchingPairForSum(new int[]{1, 2, 4, 4}, 8), 8);

        //printResult(findMatchingPairForSum2(new int[]{1, 2, 3, 9}, 8), 8);
        //printResult(findMatchingPairForSum2(new int[]{1, 2, 4, 5, 3}, 8), 8);

        System.out.println(hasPairWithSum(new int[]{1, 2, 3, 9, 6}, 8));
        System.out.println(hasPairWithSum(new int[]{1, 2, 4, 5, 2}, 8));
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

    //Big O (Time complexity) - O(n + n)
    private static int[] findMatchingPairForSum2(int[] array, int sum) {
        Map<Integer, Integer> mapWithPossiblePairs = new HashMap<>(); //Map with matching pair and index of each value in the array
        for (int index = 0; index < array.length; index++) {
            mapWithPossiblePairs.put(sum - array[index], index);
        }

        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            Integer indexOfMatch = mapWithPossiblePairs.get(array[currentIndex]);
            if (indexOfMatch == null || indexOfMatch == currentIndex) {
                continue;
            }

            return new int[]{array[currentIndex], array[indexOfMatch]};
        }

        return null;
    }

    //Google video version
    //Big O (Time complexity) - O(n)
    private static boolean hasPairWithSum(int[] array, int sum) {
        Set<Integer> complements = new HashSet<>();
        for (int value : array) {
            if (complements.contains(value)) {
                return true;
            }
            complements.add(sum - value);
        }

        return false;
    }
}

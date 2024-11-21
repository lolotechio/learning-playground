package io.lolotech.udemy.dsa.video88;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRecurringCharacter {

    //Google question
    //Given an array = [2, 5, 1, 2, 3, 5, 1, 2, 4]
    //It should return 2

    //Given an array = [2, 1, 1, 2, 3, 5, 1, 2, 4]
    //It should return 1

    //Given an array = [2, 3, 4, 5]
    //It should return undefined

    public static void main(String[] args) {
        System.out.println(firstRecurringChar(new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(firstRecurringChar(new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(firstRecurringChar(new int[]{2, 3, 4, 5}));

        System.out.println(firstRecurringChar2(new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(firstRecurringChar2(new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(firstRecurringChar2(new int[]{2, 3, 4, 5}));

        System.out.println(firstRecurringChar3(new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(firstRecurringChar3(new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(firstRecurringChar3(new int[]{2, 3, 4, 5}));
    }

    //Big O (Time complexity) - O(n^2)
    //This solution is not completely correct, it does not work for the second array [2, 1, 1, 2, 3, 5, 1, 2, 4]
    private static int firstRecurringChar(int[] array) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return array[i];
                }
            }
        }

        return -1;
    }

    //Big O (Time complexity) - O(n)
    private static int firstRecurringChar2(int[] array) {
        if (array == null) {
            return -1;
        }

        Map<Integer, Boolean> recurringNumbersMap = new HashMap<>();
        for (int value : array) {
            if (recurringNumbersMap.get(value) != null) {
                return value;
            }

            recurringNumbersMap.put(value, true);
        }

        return -1;
    }

    //Big O (Time complexity) - O(n)
    private static int firstRecurringChar3(int[] array) {
        if (array == null) {
            return -1;
        }

        Set<Integer> recurringNumbersSet = new HashSet<>();
        for (int value : array) {
            if (!recurringNumbersSet.add(value)) {
                return value;
            }
        }

        return -1;
    }
}

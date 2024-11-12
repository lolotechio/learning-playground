package io.lolotech.udemy.dsa.video57;

import java.util.HashMap;
import java.util.Map;

public class ArraysCommonItems {

    //Give 2 arrays, create a function that let's a user know (true/false) whether these 2 arrays contain any common items
    //For example:
    //array1 = ['a', 'b', 'c', 'x']
    //array 2 = ['z', 'y', 'i']
    //should return false
    //------------------------------
    //array1 = ['a', 'b', 'c', 'x']
    //array 2 = ['z', 'y', 'x']
    //should return true

    public static void main(String[] args) {
        System.out.println("===== First compareArrays method - O(a*b) =====");
        System.out.println(compareArrays(new char[]{'a', 'b', 'c', 'x'}, new char[]{'z', 'y', 'i'}));
        System.out.println(compareArrays(new char[]{'a', 'b', 'c', 'x'}, new char[]{'z', 'y', 'x'}));

        System.out.println("===== Second compareArrays method - O(a+b) =====");
        System.out.println(compareArrays2(new char[]{'a', 'b', 'c', 'x'}, new char[]{'z', 'y', 'i'}));
        System.out.println(compareArrays2(new char[]{'a', 'b', 'c', 'x'}, new char[]{'z', 'y', 'x'}));
    }

    //Big O (Time complexity) - O(a*b) - because there are two different arrays that can have different sizes
    private static boolean compareArrays(char[] array1, char[] array2) {
        for (char value1 : array1) {
            for (char value2 : array2) {
                if (value1 == value2) {
                    return true;
                }
            }
        }

        return false;
    }

    //Big O (Time complexity) - O(a+b) - because we have two loops, but not nested
    //This method improves the complexity of the first solution in the method compareArrays
    private static boolean compareArrays2(char[] array1, char[] array2) {
        //loop through array1 and create a map where keys == items in the array1
        Map<Character, Boolean> mapWithArray1Values = new HashMap<>();
        for (char c : array1) {
            mapWithArray1Values.put(c, true);
        }

        //loop through array2 and check if items in array2 exists in created map
        for (char c : array2) {
            if (mapWithArray1Values.get(c) != null) {
                return true;
            }
        }

        return false;
    }
}

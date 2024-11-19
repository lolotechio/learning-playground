package io.lolotech.udemy.dsa.video75;

import java.util.*;

public class MergeSortedArrays {

    //Given two arrays that are sorted, merge the two arrays into one array sorted
    //Array 1: [0, 3, 4, 31]
    //Array 2: [4, 6, 30]
    //Result: [0, 3, 4, 4, 6, 30, 31]

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30})));
        System.out.println(Arrays.toString(mergeSortedArrays(null, null)));
        System.out.println(Arrays.toString(mergeSortedArrays2(null, null)));
        System.out.println(Arrays.toString(mergeSortedArrays2(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30})));
    }

    //Big O (Time complexity) - O(n+m)
    private static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] validatedInputs = validateInputs(array1, array2);
        if (validatedInputs != null) {
            return validatedInputs;
        }

        int array1Index = 0;
        int array2Index = 0;

        int[] mergedArray = new int[array1.length + array2.length];
        int index = 0;

        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] <= array2[array2Index]) {
                mergedArray[index] = array1[array1Index];
                array1Index++;
            } else {
                mergedArray[index] = array2[array2Index];
                array2Index++;
            }
            index++;
        }

        if (array1Index < array1.length) {
            addLastItems(array1, array1Index, mergedArray, index);
        }

        if (array2Index < array2.length) {
            addLastItems(array2, array2Index, mergedArray, index);
        }

        return mergedArray;
    }

    private static void addLastItems(int[] array, int arrayIndex, int[] mergedArray, int index) {
        for (int i = arrayIndex; i < array.length; i++) {
            mergedArray[index] = array[i];
            index++;
        }
    }

    //Big O (Time complexity) - O((n+m)log(n+m))
    private static int[] mergeSortedArrays2(int[] array1, int[] array2) {
        int[] validatedInputs = validateInputs(array1, array2);
        if (validatedInputs != null) {
            return validatedInputs;
        }

        List<Integer> list1 = Arrays.stream(array1).boxed().toList();
        List<Integer> list2 = Arrays.stream(array2).boxed().toList();

        List<Integer> mergedLists = new ArrayList<>(list1);
        mergedLists.addAll(list2);
        mergedLists = mergedLists.stream().sorted().toList();

        return mergedLists.stream().mapToInt(i -> i).toArray();
    }

    private static int[] validateInputs(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) {
            return new int[0];
        }

        if (array1 == null) {
            return array2;
        }

        if (array2 == null) {
            return array1;
        }

        return null;
    }
}

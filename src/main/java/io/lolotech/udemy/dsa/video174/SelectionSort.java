package io.lolotech.udemy.dsa.video174;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{6, 5, 3, 1, 8, 7, 2, 4})));
        System.out.println(Arrays.toString(selectionSort(new int[]{99, 4, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
        System.out.println(Arrays.toString(selectionSort(new int[]{10, 0, 100000, 100, 10000, 1000, 1000000000, 1000000})));
    }

    //O(n^2)
    private static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
        }

        return array;
    }
}

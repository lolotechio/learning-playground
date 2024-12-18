package io.lolotech.udemy.dsa.video178;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{6, 5, 3, 1, 8, 7, 2, 4})));
        System.out.println(Arrays.toString(insertionSort(new int[]{99, 4, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
        System.out.println(Arrays.toString(insertionSort(new int[]{10, 0, 100000, 100, 10000, 1000, 1000000000, 1000000})));
    }

    //O(n^2)
    private static int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        return array;
    }
}

package io.lolotech.udemy.dsa.video171;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{6, 5, 3, 1, 8, 7, 2, 4})));
        System.out.println(Arrays.toString(bubbleSort(new int[]{99, 4, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
        System.out.println(Arrays.toString(bubbleSort(new int[]{10, 0, 100000, 100, 10000, 1000, 1000000000, 1000000})));
    }

    //O(n^2)
    private static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}

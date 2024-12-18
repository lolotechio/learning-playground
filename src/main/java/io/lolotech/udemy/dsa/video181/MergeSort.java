package io.lolotech.udemy.dsa.video181;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{6, 5, 3, 1, 8, 7, 2, 4})));
        System.out.println(Arrays.toString(mergeSort(new int[]{99, 4, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
        System.out.println(Arrays.toString(mergeSort(new int[]{10, 0, 100000, 100, 10000, 1000, 1000000000, 1000000})));
    }

    //O(n log n)
    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int halfLength = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, halfLength);
        int[] right = Arrays.copyOfRange(array, halfLength, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }
}

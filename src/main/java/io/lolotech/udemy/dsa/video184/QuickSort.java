package io.lolotech.udemy.dsa.video184;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array1 = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        int[] array2 = new int[]{99, 4, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] array3 = new int[]{10, 0, 100000, 100, 10000, 1000, 1000000000, 1000000};
        System.out.println(Arrays.toString(quickSort(array1, 0, array1.length - 1)));
        System.out.println(Arrays.toString(quickSort(array2, 0, array2.length - 1)));
        System.out.println(Arrays.toString(quickSort(array3, 0, array3.length - 1)));
    }

    //O(n log n) - worst case O(n^2) if we pick the pivot as the smallest or the largest number
    private static int[] quickSort(int[] array, int left, int right) {
        int pivot;
        int partitionIndex;
        if (left < right) {
            pivot = right;
            partitionIndex = partition(array, pivot, left, right);

            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }

        return array;
    }

    private static int partition(int[] array, int pivot, int left, int right) {
        int pivotValue = array[pivot];
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, right, partitionIndex);
        return partitionIndex;
    }

    private static void swap(int[] array,int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}

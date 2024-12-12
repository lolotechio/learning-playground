package io.lolotech.udemy.dsa.video161;

public class Fibonacci {

    // Given a number N return the index value of the Fibonacci sequence, where the sequence is:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
    // the pattern of the sequence is that each value is the sum of the 2 previous values, that means for N = 5 -> 2+3

    public static void main(String[] args) {
        System.out.println(fibonacciIterative(13));
        System.out.println(fibonacciRecursive(13));
    }

    private static int fibonacciIterative(int number) {
        var array = new int[number + 1];
        array[0] = 0;
        if (number > 0) array[1] = 1;

        for (int i = 2; i < number + 1; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }

        return array[number];
    }

    private static int fibonacciRecursive(int number) {
        if (number < 2) {
            return number;
        }

        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }
}

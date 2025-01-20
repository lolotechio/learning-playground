package io.lolotech.udemy.dsa.video218;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonacciMemoized {

    // Given a number N return the index value of the Fibonacci sequence, where the sequence is:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
    // the pattern of the sequence is that each value is the sum of the 2 previous values, that means for N = 5 -> 2+3

    private static Map<Integer, Integer> cache = new HashMap<>();
    private static int calculations = 0;

    public static void main(String[] args) {
        System.out.println(fibonacciMemoized(30));
        System.out.println(calculations);
    }

    //O(n)
    private static int fibonacciMemoized(int number) {
        calculations++;
        if (cache.get(number) != null) {
            return cache.get(number);
        }

        if (number < 2) {
            return number;
        }

        int result = fibonacciMemoized(number - 1) + fibonacciMemoized(number - 2);
        cache.put(number, result);
        return result;
    }

    //O(2^n)
    private static int fibonacciRecursive(int number) {
        calculations++;
        if (number < 2) {
            return number;
        }

        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }

    private static int fibonacciBottomUp(int number) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);

        for (int i = 2; i<= number; i++) {
            result.add(result.get(i - 2) + result.get(i - 1));
        }

        return result.getLast();
    }
}

package io.lolotech.exercises;

import java.util.Arrays;

public class FizzBuzz {

    /*
    Given an integer n, return a string array answer (1-indexed) where:
    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.

    Example 1:
    Input: n = 3
    Output: ["1","2","Fizz"]

    Example 2:
    Input: n = 5
    Output: ["1","2","Fizz","4","Buzz"]

    Example 3:
    Input: n = 15
    Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzBuzz(3)));
        System.out.println(Arrays.toString(fizzBuzz(5)));
        System.out.println(Arrays.toString(fizzBuzz(15)));
    }

    //Time complexity O(n)
    private static String[] fizzBuzz(int n) {
        String[] result = new String[n];
        for (int x = 1; x <= n; x++) {
            result[x - 1] = calculateFizzBuzz(x);
        }

        return result;
    }

    private static String calculateFizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}

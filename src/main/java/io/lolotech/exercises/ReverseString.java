package io.lolotech.exercises;

public class ReverseString {

    /*
    Write a function that reverses a string. The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:
    Input: s = ['h','e','l','l','o']
    Output: ['o','l','l','e','h']

    Example 2:
    Input: s = ['H','a','n','n','a','h']
    Output: ['h','a','n','n','a','H']
     */

    public static void main(String[] args) {
        System.out.println(reverseString(new char[]{'h', 'e', 'l', 'l', 'o'}));
        System.out.println(reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}));
    }

    //Time complexity O(n)
    //Space complexity O(1)
    //  The function operates directly on the input array (char[] input), reversing it in place.
    //  No additional data structures are used to store intermediate results.
    //  The only extra space used is for a single temporary variable (temp), which is a constant amount of space.
    private static char[] reverseString(char[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }

        for (int i = 0; i < input.length / 2; i++) {
            char temp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i - 1] = temp;
        }

        return input;
    }

    private static char[] reverseStringOptimized(char[] input) {
        for (int i = 0, j = input.length - 1; i < j; i++, j--) {
            swap(input, i, j);
        }
        return input;
    }

    private static void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

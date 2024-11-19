package io.lolotech.udemy.dsa.video73;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {

    //Create a method that reverses a string:
    //'Hi, my name is Lucian' should be:
    //'naicuL si eman ym ,iH'

    public static void main(String[] args) {
        System.out.println(reverseString("Hi, my name is Lucian"));
        System.out.println(reverseString2("Hi, my name is Lucian"));
        System.out.println(reverseString3("Hi, my name is Lucian"));
    }

    //Big O (Time complexity) - O(n)
    private static String reverseString(String input) {
        if (input == null) {
            return "N/A";
        }

        if (input.length() == 1) {
            return input;
        }

        char[] charArray = input.toCharArray();
        char[] reversedCharArray = new char[charArray.length];
        int index = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversedCharArray[index] = charArray[i];
            index++;
        }

        return String.copyValueOf(reversedCharArray);
    }

    //Big O (Time complexity) - O(n+n)
    private static String reverseString2(String input) {
        char[] charArray = input.toCharArray();

        List<Character> listOfChars = new ArrayList<>();

        for (char c : charArray) {
            listOfChars.add(c);
        }

        Collections.reverse(listOfChars);

        return listOfChars.stream().map(String::valueOf).collect(Collectors.joining());
    }

    //Big O (Time complexity) - O(n)
    private static String reverseString3(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

}

package io.lolotech.exercises;

import java.util.Map;

public class RomanToInteger {

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. 
    The number 27 is written as XXVII, which is XX + V + II.
    
    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. 
    Instead, the number four is written as IV. Because the one is before the five we subtract it making four. 
    The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:    
    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.    
    
    Example 1:    
    Input: s = "III"
    Output: 3
    Explanation: III = 3.
    
    Example 2:    
    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.
    
    Example 3:
    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    static Map<Character, Integer> romanToIntegerMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static void main(String[] args) {
        System.out.println(romanToIntegerOptimized("III"));
        System.out.println(romanToIntegerOptimized("LVIII"));
        System.out.println(romanToIntegerOptimized("MCMXCIV"));
        System.out.println(romanToIntegerOptimized("MMMCMXCIX"));
    }

    //TC: O(n)
    //SC: O(1)
    private static int romanToInteger(String roman) {
        char[] chars = roman.toCharArray();

        int number = 0;
        for (int i = 0; i < chars.length; i++) {
            int current = romanToIntegerMap.get(chars[i]);
            int next = 0;
            if (i < chars.length - 1) {
                next = romanToIntegerMap.get(chars[i + 1]);
            }

            if (current < next) {
                number += next - current;
                i++;
            } else {
                number += current;
            }
        }

        return number;
    }

    //TC: O(n)
    //SC: O(1)
    private static int romanToIntegerOptimized(String roman) {
        int total = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int current = romanToIntegerMap.get(roman.charAt(i));

            if (current < prevValue) {
                total -= current;
            } else {
                total += current;
            }

            prevValue = current;
        }

        return total;
    }
}

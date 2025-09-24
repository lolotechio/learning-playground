package io.lolotech.udemy.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    //Given a string, find the length of the longest substring without repeating characters.
    //Example 1:
    //Input: "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(lengthOfLongestSubstring("abcbdca")); // Output: 4
        System.out.println(lengthOfLongestSubstring("cccccccc")); // Output: 1
        System.out.println(lengthOfLongestSubstring("")); // Output: 0

        System.out.println("--- Optimized ---");

        System.out.println(lengthOfLongestSubstringOptimized("abcabcbb")); // Output: 3
        System.out.println(lengthOfLongestSubstringOptimized("abcbdca")); // Output: 4
        System.out.println(lengthOfLongestSubstringOptimized("abcbdaac")); // Output: 4
        System.out.println(lengthOfLongestSubstringOptimized("cccccccc")); // Output: 1
        System.out.println(lengthOfLongestSubstringOptimized("")); // Output: 0
    }

    // Optimized approach using sliding window
    // Time complexity: O(n)
    // Space complexity: O(n)
    private static int lengthOfLongestSubstringOptimized(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] charArray = s.toCharArray();
        int left = 0;
        int maxLength = 0;

        Map<Character, Integer> seenChars = new HashMap<>();
        for (int right = 0; right < charArray.length; right++) {
            char currentChar = charArray[right];
            if (seenChars.get(currentChar) != null) {
                if (seenChars.get(currentChar) >= left) {
                    left = seenChars.get(currentChar) + 1;
                }
            }

            seenChars.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Brute force approach
    // Time complexity: O(n^2)
    // Space complexity: O(n)
    private static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < charArray.length; i++) {
            Map<Character, Character> seenChars = new java.util.HashMap<>();
            for (int j = i + 1; j < charArray.length; j++) {
                if (seenChars.get(charArray[j]) == null) {
                    seenChars.put(charArray[j], charArray[j]);
                } else {
                    break;
                }
            }

            maxLength = Math.max(maxLength, seenChars.size());
        }

        return maxLength;
    }

}

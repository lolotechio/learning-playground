package io.lolotech.exercises;

import java.util.Arrays;

public class ValidAnagram {

    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false
     */

    public static void main(String[] args) {
        System.out.println(isAnagramOptimized("anagram", "nagaram "));
        System.out.println(isAnagramOptimized("rat", "car"));
        System.out.println(isAnagramOptimized("new york times", "monkeys write"));
        System.out.println(isAnagramOptimized("mcdonald's restaurants", "uncle sam's standard rot"));
    }

    //TC: O(N+M) -> it iterates over both strings once
    //SC: O(1) -> the int[256] array has a fixed size
    private static boolean isAnagramOptimized(String s, String t) {
        if (s == null || t == null) return false;

        s = s.replaceAll(" ", "");
        t = t.replaceAll(" ", "");
        if (s.length() != t.length()) return false;

        int[] count = new int[256];
        for (char c : s.toCharArray()) count[c]++;
        for (char c : t.toCharArray()) {
            if (--count[c] < 0) return false;
        }
        return true;
    }

    //The algorithm does not correctly check the frequency of characters, only their presence. For example: isAnagram("aabb", "abcc"); // Returns true incorrectly.
    //TC: O(NM) - contains runs in O(N) for each character in t (with length of M)
    //SC: O(N+M) - replaceAll creates new String copies -> O(N+M)
    private static boolean isAnagram2(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        s = s.replaceAll(" ", "");
        t = t.replaceAll(" ", "");

        if (s.length() != t.length()) {
            return false;
        }

        char[] tChars = t.toCharArray();
        for (char c : tChars) {
            if (!s.contains(String.valueOf(c))) {
                return false;
            }
        }

        return true;
    }

    //TC: O(N log N + M log M) -> sorting runs in O(N log N) for both Strings
    //SC: O(N + M) ->Sorting requires additional space: O(N+M) due to the sorted arrays
    private static boolean isAnagram3(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        s = s.replaceAll(" ", "");
        t = t.replaceAll(" ", "");
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return new String(sChar).equals(new String(tChar));
    }
}

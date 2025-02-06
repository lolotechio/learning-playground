package io.lolotech.exercises;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterString {

    /*
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

    Example 1:
    Input: s = "leetcode"
    Output: 0
    Explanation:
    The character 'l' at index 0 is the first character that does not occur at any other index.

    Example 2:
    Input: s = "loveleetcode"
    Output: 2

    Example 3:
    Input: s = "aabb"
    Output: -1
     */

    public static void main(String[] args) {
        System.out.println(firstUniqueCharacter("leetcode"));
        System.out.println(firstUniqueCharacter("loveleetcode"));
        System.out.println(firstUniqueCharacter("aabb"));
    }

    //TC: O(n)
    //SC: O(1)
    private static int firstUniqueCharacter(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}

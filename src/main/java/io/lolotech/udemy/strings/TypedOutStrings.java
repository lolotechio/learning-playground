package io.lolotech.udemy.strings;

public class TypedOutStrings {

    //Given two strings s and t, return true if they are equal when both are typed out.
    //Any '#' that appears in th string counts as a backspace character.
    //Example 1:
    //Input: s = "cb#d" -> "cd"
    //       t = "ab##d" -> "d"
    //Output: false
    //Example 2:
    //Input: s = "ab#c" -> "ac"
    //       t = "ad#c" -> "ac"
    //Output: true

    public static void main(String[] args) {
        System.out.println(equalStrings("cb#d", "ab##d")); // false
        System.out.println(equalStrings("ab#c", "ad#c")); // true
    }

    // O(n) time | O(n) space
    private static boolean equalStrings(String s, String t) {
        return typedOut(s).equals(typedOut(t));
    }

    private static String typedOut(String s) {
        char[] chars = s.toCharArray();

        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c == '#') {
                if (!result.isEmpty()) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

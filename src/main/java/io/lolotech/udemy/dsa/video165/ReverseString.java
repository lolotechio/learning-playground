package io.lolotech.udemy.dsa.video165;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseStringRecursive("yoyo master"));
        System.out.println(reverseStringRecursive2("yoyo master"));
    }

    private static String reverseStringRecursive(String s) {
        if (s.length() <= 1) {
            return s;
        }

        return s.charAt(s.length() - 1) + reverseStringRecursive(s.substring(0, s.length() - 1));
    }

    private static String reverseStringRecursive2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        return reverseStringRecursive2(s.substring(1)) + s.charAt(0) ;
    }
}

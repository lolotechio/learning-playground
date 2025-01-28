package io.lolotech.exercises;

import java.util.Map;
import java.util.Optional;

public class ExcelSheetColumnNumber {

    /*
    Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
    For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

    Example 1:
    Input: columnTitle = "A"
    Output: 1

    Example 2:
    Input: columnTitle = "AB"
    Output: 28

    Example 3:
    Input: columnTitle = "ZY"
    Output: 701
     */

    private static Map<Character, Integer> alphabetMap = Map.ofEntries(
            Map.entry('A', 1),
            Map.entry('B', 2),
            Map.entry('C', 3),
            Map.entry('D', 4),
            Map.entry('E', 5),
            Map.entry('F', 6),
            Map.entry('G', 7),
            Map.entry('H', 8),
            Map.entry('I', 9),
            Map.entry('J', 10),
            Map.entry('K', 11),
            Map.entry('L', 12),
            Map.entry('M', 13),
            Map.entry('N', 14),
            Map.entry('O', 15),
            Map.entry('P', 16),
            Map.entry('Q', 17),
            Map.entry('R', 18),
            Map.entry('S', 19),
            Map.entry('T', 20),
            Map.entry('U', 21),
            Map.entry('V', 22),
            Map.entry('W', 23),
            Map.entry('X', 24),
            Map.entry('Y', 25),
            Map.entry('Z', 26)
    );

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("XYZ"));
    }

    private static int titleToNumber(String columnTitle) {
        if (columnTitle == null) {
            return 0;
        }

        char[] letters = columnTitle.toCharArray();
        if (letters.length == 1) {
            return Optional.ofNullable(alphabetMap.get(letters[0])).orElse(0);
        }

        int columnNumber = 0;
        for (int i = 0; i < letters.length; i++) {
            if (alphabetMap.get(letters[i]) == null) {
                return 0;
            }

            columnNumber += (int) (alphabetMap.get(letters[i]) * Math.pow(26, letters.length - i - 1));
        }

        return columnNumber;
    }
}

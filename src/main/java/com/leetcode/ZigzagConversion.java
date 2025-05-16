package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();

        // Example 1
        System.out.println("Example 1: " + solution.convert("PAYPALISHIRING", 3)); // Output: "PAHNAPLSIIGYIR"

        // Example 2
        System.out.println("Example 2: " + solution.convert("PAYPALISHIRING", 4)); // Output: "PINALSIGYAHRPI"

        // Example 3
        System.out.println("Example 3: " + solution.convert("A", 1)); // Output: "A"
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;

        // Create a list of StringBuilder for each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            // Append the character to the current row
            rows.get(currentRow).append(c);

            // Change direction when reaching the top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;

            // Move to the next row depending on the direction
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into one result string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}

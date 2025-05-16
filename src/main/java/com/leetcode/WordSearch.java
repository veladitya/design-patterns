package com.leetcode;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        // Example 1
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("Example 1: " + solution.exist(board1, "ABCCED"));  // Output: true

        // Example 2
        System.out.println("Example 2: " + solution.exist(board1, "SEE"));     // Output: true

        // Example 3
        System.out.println("Example 3: " + solution.exist(board1, "ABCB"));    // Output: false
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Try to find the word starting from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Base cases
        if (index == word.length()) return true; // Word found
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        // Save the current character and mark as visited
        char temp = board[row][col];
        board[row][col] = '#'; // Mark the cell as visited

        // Explore the four directions
        boolean found = dfs(board, word, row - 1, col, index + 1) || // Up
                dfs(board, word, row + 1, col, index + 1) || // Down
                dfs(board, word, row, col - 1, index + 1) || // Left
                dfs(board, word, row, col + 1, index + 1);   // Right

        // Restore the character after visiting
        board[row][col] = temp;
        return found;
    }
}

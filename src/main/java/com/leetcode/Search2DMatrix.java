package com.leetcode;

public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix solution = new Search2DMatrix();

        // Example 1
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("Example 1: " + solution.searchMatrix(matrix1, target1));  // Output: true

        // Example 2
        int[][] matrix2 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target2 = 13;
        System.out.println("Example 2: " + solution.searchMatrix(matrix2, target2));  // Output: false
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Map mid to 2D coordinates
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return false;
    }
}

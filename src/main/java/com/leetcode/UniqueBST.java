package com.leetcode;

public class UniqueBST {

    public static void main(String[] args) {
        UniqueBST solution = new UniqueBST();

        // Example 1
        int n1 = 3;
        System.out.println("Example 1: " + solution.numTrees(n1));  // Output: 5

        // Example 2
        int n2 = 1;
        System.out.println("Example 2: " + solution.numTrees(n2));  // Output: 1
    }

    public int numTrees(int n) {
        // Array to store the number of unique BSTs for each count of nodes
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1; // Empty tree
        dp[1] = 1; // Single node tree

        // Fill the dp array using the Catalan number formula
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int left = dp[root - 1];   // Number of unique BSTs in the left subtree
                int right = dp[nodes - root]; // Number of unique BSTs in the right subtree
                dp[nodes] += left * right;  // Multiply and add to the total for this node count
            }
        }

        return dp[n];
    }
}

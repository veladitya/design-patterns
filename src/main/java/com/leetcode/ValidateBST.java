package com.leetcode;


public class ValidateBST {

    public static void main(String[] args) {
        ValidateBST solution = new ValidateBST();

        // Example 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Example 1: " + solution.isValidBST(root1));  // Output: true

        // Example 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Example 2: " + solution.isValidBST(root2));  // Output: false
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // Base case: empty node is valid
        if (node == null) return true;

        // Check if the current node's value is within the valid range
        if (node.val <= min || node.val >= max) return false;

        // Recursively validate the left and right subtrees
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

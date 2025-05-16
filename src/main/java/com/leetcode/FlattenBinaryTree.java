package com.leetcode;


public class FlattenBinaryTree {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private TreeNode prev = null;  // Remember the last coach we added to the train

    public void flatten(TreeNode root) {
        if (root == null) return;  // If there's no tree, do nothing

        // Flatten the right side first (lay the right track)
        flatten(root.right);

        // Flatten the left side next (lay the left track)
        flatten(root.left);

        // Now connect the current coach to the train
        root.right = prev;  // Attach the last connected coach to the current one
        root.left = null;   // Chop off the left branch
        prev = root;        // Move the last connected coach to the current one
    }

    // Helper to print the train (flattened tree)
    public void printFlattened(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        FlattenBinaryTree solution = new FlattenBinaryTree();

        // Build the tree (like assembling the train)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        solution.flatten(root);  // Flatten the tree
        solution.printFlattened(root);  // Print the flattened train
    }
}

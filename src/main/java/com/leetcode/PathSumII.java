package com.leetcode;

import java.util.*;



public class PathSumII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        // Add the current node to the path
        currentPath.add(node.val);

        // Check if it is a leaf and path sum equals target sum
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath));  // Add a copy of the current path
        } else {
            // Recur for left and right subtrees with the updated targetSum
            dfs(node.left, targetSum - node.val, currentPath, result);
            dfs(node.right, targetSum - node.val, currentPath, result);
        }

        // Backtrack: remove the current node before returning to the previous level
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII solution = new PathSumII();

        // Example 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);
        System.out.println("Example 1: " + solution.pathSum(root1, 22));  // Output: [[5,4,11,2],[5,8,4,5]]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("Example 2: " + solution.pathSum(root2, 5));  // Output: []

        // Example 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        System.out.println("Example 3: " + solution.pathSum(root3, 0));  // Output: []
    }
}

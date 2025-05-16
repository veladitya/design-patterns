package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal solution = new LevelOrderTraversal();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Example 1: " + solution.levelOrder(root1));  // Output: [[3], [9,20], [15,7]]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println("Example 2: " + solution.levelOrder(root2));  // Output: [[1]]

        // Example 3
        TreeNode root3 = null;
        System.out.println("Example 3: " + solution.levelOrder(root3));  // Output: []
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();  // Number of nodes at the current level
            List<Integer> level = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);

                // Enqueue left and right children if they exist
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // Add the current level to the result
            result.add(level);
        }

        return result;
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

package com.leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class ZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // Queue to perform BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            // Process each node at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Add node value based on the current direction
                if (leftToRight) {
                    level.add(current.val);  // Add to the end
                } else {
                    level.addFirst(current.val);  // Add to the front for reverse order
                }

                // Add left and right children to the queue
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // Add the current level to the result list
            result.add(level);
            // Toggle the direction for the next level
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        ZigzagLevelOrderTraversal solution = new ZigzagLevelOrderTraversal();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Example 1: " + solution.zigzagLevelOrder(root1));  // Output: [[3],[20,9],[15,7]]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println("Example 2: " + solution.zigzagLevelOrder(root2));  // Output: [[1]]

        // Example 3
        TreeNode root3 = null;
        System.out.println("Example 3: " + solution.zigzagLevelOrder(root3));  // Output: []
    }
}

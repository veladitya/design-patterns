package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DFSExample {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        DFSExample dfs = new DFSExample();
        System.out.println("DFS Traversal: " + dfs.dfs(root));  // Output: [1, 2, 4, 5, 3, 6]
    }

    public List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsHelper(root, result);
        return result;
    }

    private void dfsHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);        // Visit the node
        dfsHelper(node.left, result);  // Visit left subtree
        dfsHelper(node.right, result); // Visit right subtree
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package com.leetcode;



public class ConnectNextRightPointers {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int val) { this.val = val; }
    }

    public Node connect(Node root) {
        if (root == null) return null;

        // Start with the leftmost node of the current level
        Node leftmost = root;

        while (leftmost.left != null) { // Process level by level
            Node current = leftmost;

            while (current != null) {
                // Connect left child to right child of the same parent
                current.left.next = current.right;

                // Connect right child to the next parent's left child if available
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                // Move to the next node at the same level
                current = current.next;
            }

            // Move to the next level (leftmost node of the next level)
            leftmost = leftmost.left;
        }

        return root;
    }

    // Print the tree using next pointers
    public void printTree(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("NULL");
            levelStart = levelStart.left;
        }
    }

    public static void main(String[] args) {
        ConnectNextRightPointers solution = new ConnectNextRightPointers();

        // Example 1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        root1 = solution.connect(root1);
        System.out.println("Example 1: ");
        solution.printTree(root1);  // Output: 1 -> NULL, 2 -> 3 -> NULL, 4 -> 5 -> 6 -> 7 -> NULL

        // Example 2
        Node root2 = null;
        root2 = solution.connect(root2);
        System.out.println("Example 2: ");
        solution.printTree(root2);  // Output: (nothing)
    }
}

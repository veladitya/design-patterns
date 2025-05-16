package com.leetcode;

import java.util.*;



public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If node is already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone the node
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // Recursively clone all the neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    // Print graph for verification
    public void printGraph(Node node) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Node " + current.val + " -> ");
            for (Node neighbor : current.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        // Example 1: Constructing the input graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedGraph = solution.cloneGraph(node1);
        System.out.println("Cloned Graph:");
        solution.printGraph(clonedGraph);  // Should print the same graph structure as input

        // Example 2: Empty graph
        Node emptyGraph = null;
        Node clonedEmpty = solution.cloneGraph(emptyGraph);
        System.out.println("Cloned Empty Graph: " + (clonedEmpty == null ? "[]" : "Not Empty"));
    }
}

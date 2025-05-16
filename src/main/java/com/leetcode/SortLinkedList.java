package com.leetcode;

public class SortLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        // Base case: if list is empty or has one element
        if (head == null || head.next == null) return head;

        // Step 1: Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Split the list

        // Step 2: Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    // Helper function to find the middle of the list
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append remaining nodes
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    // Helper to print the linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortLinkedList solution = new SortLinkedList();

        // Example 1
        ListNode head1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.print("Example 1: ");
        ListNode sorted1 = solution.sortList(head1);
        solution.printList(sorted1);  // Output: [1,2,3,4]

        // Example 2
        ListNode head2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        System.out.print("Example 2: ");
        ListNode sorted2 = solution.sortList(head2);
        solution.printList(sorted2);  // Output: [-1,0,3,4,5]

        // Example 3
        ListNode head3 = null;
        System.out.print("Example 3: ");
        ListNode sorted3 = solution.sortList(head3);
        solution.printList(sorted3);  // Output: []
    }
}

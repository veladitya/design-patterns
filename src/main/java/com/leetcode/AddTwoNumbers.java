package com.leetcode;


public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Helper method to print the linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Creating l1 = [2,4,3]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Creating l2 = [5,6,4]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result list
        System.out.print("Result: ");
        printList(result);  // Expected output: 7 0 8
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Placeholder for the result list
        ListNode current = dummy;
        int carry = 0;

        // Iterate through both lists until the end
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with the carry from the previous iteration

            // Add the value from l1 if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add the value from l2 if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Update carry for next iteration
            carry = sum / 10;

            // Create a new node with the digit value (sum % 10)
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;  // Return the head of the result list
    }
}

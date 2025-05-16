package com.leetcode;

public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid element is greater than the rightmost element
            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half including mid
                right = mid;
            }
        }

        // At the end, left will point to the minimum element
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArray solution = new FindMinInRotatedSortedArray();

        // Example 1
        int[] nums1 = {3,4,5,1,2};
        System.out.println("Example 1: " + solution.findMin(nums1));  // Output: 1

        // Example 2
        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println("Example 2: " + solution.findMin(nums2));  // Output: 0

        // Example 3
        int[] nums3 = {11,13,15,17};
        System.out.println("Example 3: " + solution.findMin(nums3));  // Output: 11
    }
}

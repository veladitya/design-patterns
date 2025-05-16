package com.leetcode;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

        // Example 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Example 1: " + solution.search(nums1, target1));  // Output: 4

        // Example 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Example 2: " + solution.search(nums2, target2));  // Output: -1

        // Example 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Example 3: " + solution.search(nums3, target3));  // Output: -1
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid element is the target
            if (nums[mid] == target) return mid;

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target is in the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // Search in the right half
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                // Target is in the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // Search in the left half
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

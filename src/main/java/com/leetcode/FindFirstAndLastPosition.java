package com.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        FindFirstAndLastPosition solution = new FindFirstAndLastPosition();

        // Example 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        System.out.println("Example 1: " + Arrays.toString(solution.searchRange(nums1, target1)));  // Output: [3,4]

        // Example 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        System.out.println("Example 2: " + Arrays.toString(solution.searchRange(nums2, target2)));  // Output: [-1,-1]

        // Example 3
        int[] nums3 = {};
        int target3 = 0;
        System.out.println("Example 3: " + Arrays.toString(solution.searchRange(nums3, target3)));  // Output: [-1,-1]
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the first occurrence of the target
        result[0] = findPosition(nums, target, true);
        // Find the last occurrence of the target
        result[1] = findPosition(nums, target, false);

        return result;
    }

    // Helper method to find the position of the target
    private int findPosition(int[] nums, int target, boolean findFirst) {
        int left = 0;
        int right = nums.length - 1;
        int position = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                position = mid;
                // Move left for the first occurrence
                if (findFirst) {
                    right = mid - 1;
                } else { // Move right for the last occurrence
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return position;
    }
}

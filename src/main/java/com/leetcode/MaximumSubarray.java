package com.leetcode;

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        // Example 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Example 1: " + solution.maxSubArray(nums1));  // Output: 6

        // Example 2
        int[] nums2 = {1};
        System.out.println("Example 2: " + solution.maxSubArray(nums2));  // Output: 1

        // Example 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Example 3: " + solution.maxSubArray(nums3));  // Output: 23
    }

    public int maxSubArray(int[] nums) {
        // Initialize current sum and max sum
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Choose the maximum between current element and sum of current subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the max sum if current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

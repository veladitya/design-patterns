package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Example 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Example 1: " + solution.threeSum(nums1));  // Output: [[-1,-1,2],[-1,0,1]]

        // Example 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Example 2: " + solution.threeSum(nums2));  // Output: []

        // Example 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Example 3: " + solution.threeSum(nums3));  // Output: [[0,0,0]]
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        // Step 1: Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Move right to increase sum
                } else {
                    right--; // Move left to decrease sum
                }
            }
        }
        return result;
    }
}

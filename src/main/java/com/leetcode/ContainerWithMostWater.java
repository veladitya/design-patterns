package com.leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Example 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Example 1: " + solution.maxArea(height1));  // Output: 49

        // Example 2
        int[] height2 = {1, 1};
        System.out.println("Example 2: " + solution.maxArea(height2));  // Output: 1
    }

    public int maxArea(int[] height) {
        int left = 0;               // Start pointer
        int right = height.length - 1;  // End pointer
        int maxArea = 0;

        while (left < right) {
            // Calculate the area with the current pair of lines
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;

            // Update maximum area if current area is greater
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

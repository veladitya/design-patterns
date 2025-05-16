package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        // Test cases
        System.out.println("Example 1: " + solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println("Example 2: " + solution.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println("Example 3: " + solution.lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            // Slide the window if a duplicate is found
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            charSet.add(s.charAt(right));

            // Update the max length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

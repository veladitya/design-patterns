package com.leetcode;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();

        // Test cases
        System.out.println("Example 1: " + solution.longestPalindrome("babad")); // Output: "bab" or "aba"
        System.out.println("Example 2: " + solution.longestPalindrome("cbbd"));  // Output: "bb"
        System.out.println("Example 3: " + solution.longestPalindrome("a"));     // Output: "a"
        System.out.println("Example 4: " + solution.longestPalindrome("ac"));    // Output: "a" or "c"
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around a single character (odd length palindrome)
            int len1 = expandFromCenter(s, i, i);
            // Expand around two adjacent characters (even length palindrome)
            int len2 = expandFromCenter(s, i, i + 1);

            int maxLength = Math.max(len1, len2);

            // Update the start and end pointers for the longest palindrome
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        // Extract the longest palindrome substring
        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

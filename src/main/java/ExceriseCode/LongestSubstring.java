package ExceriseCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

   // input = abcabcbb - output = abc

    /**
     * Finds the length of the longest substring without repeating characters.
     * Uses a sliding window approach with a HashSet to track unique characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Set to store characters in the current window (for uniqueness check)
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0; // Stores the maximum length found
        int left = 0;      // Left pointer of the sliding window

        // Iterate with the right pointer to expand the window
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the current character is already in the set, it means it's a duplicate
            // We need to shrink the window from the left until the duplicate is removed
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left)); // Remove character at left pointer
                left++;                          // Move left pointer forward
            }

            // Add the current character to the set (it's now unique in the window)
            charSet.add(currentChar);

            // Update the maximum length found so far
            // The current window size is (right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Finds the actual longest substring without repeating characters.
     * This extends the previous logic to also store the start index and length
     * of the longest valid substring.
     *
     * @param s The input string.
     * @return The longest substring without repeating characters, or an empty string if input is null/empty.
     */
    public static String findLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int longestSubstrStart = 0; // Start index of the longest substring
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(currentChar);

            // If current window is longer than max, update max length and its start index
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                longestSubstrStart = left;
            }
        }

        // Extract the substring using the stored start index and calculated length
        return s.substring(longestSubstrStart, longestSubstrStart + maxLength);
    }


    public static void main(String[] args) {
        String input1 = "abcabcbb";
        int length1 = lengthOfLongestSubstring(input1);
        String substring1 = findLongestSubstring(input1);
        System.out.println("Input: \"" + input1 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + length1);
        System.out.println("Longest substring: \"" + substring1 + "\""); // Expected: "abc" (or "bca", "cab")

        System.out.println("\n--- Additional Test Cases ---");

        String input2 = "bbbbb";
        int length2 = lengthOfLongestSubstring(input2);
        String substring2 = findLongestSubstring(input2);
        System.out.println("Input: \"" + input2 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + length2);
        System.out.println("Longest substring: \"" + substring2 + "\""); // Expected: "b"

        String input3 = "pwwkew";
        int length3 = lengthOfLongestSubstring(input3);
        String substring3 = findLongestSubstring(input3);
        System.out.println("Input: \"" + input3 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + length3);
        System.out.println("Longest substring: \"" + substring3 + "\""); // Expected: "wke" or "kew"

        String input4 = "abcdefg";
        int length4 = lengthOfLongestSubstring(input4);
        String substring4 = findLongestSubstring(input4);
        System.out.println("Input: \"" + input4 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + length4);
        System.out.println("Longest substring: \"" + substring4 + "\""); // Expected: "abcdefg"

        String input5 = "";
        int length5 = lengthOfLongestSubstring(input5);
        String substring5 = findLongestSubstring(input5);
        System.out.println("Input: \"" + input5 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + length5);
        System.out.println("Longest substring: \"" + substring5 + "\""); // Expected: ""

        String input6 = "dvdf";
        int length6 = lengthOfLongestSubstring(input6);
        String substring6 = findLongestSubstring(input6);
        System.out.println("Input: \"" + input6 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + length6);
        System.out.println("Longest substring: \"" + substring6 + "\""); // Expected: "vdf"
    }
}

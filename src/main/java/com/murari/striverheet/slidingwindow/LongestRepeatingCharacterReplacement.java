package com.murari.striverheet.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {

  public int characterReplacement(String s, int k) {
    // HashMap to store the frequency of characters in the current window
    Map<Character, Integer> countMap = new HashMap<>();
    // Variable to keep track of the count of the most frequent character in the current window
    int maxCount = 0;
    // Left pointer of the sliding window
    int left = 0;

    // Iterate through the string with the right pointer
    for (int right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);
      // Increment the frequency of the current character in the map
      countMap.put(rightChar, countMap.getOrDefault(rightChar, 0) + 1);
      // Update the maxCount to the highest frequency of any character in the current window
      maxCount = Math.max(maxCount, countMap.get(rightChar));

      // If the current window size minus the maxCount character exceeds k,
      // it means we cannot make the current window valid with at most k changes
      if ((right - left + 1) - maxCount > k) {
        char leftChar = s.charAt(left);
        // Decrement the frequency of the leftmost character as we are moving the left pointer
        countMap.put(leftChar, countMap.get(leftChar) - 1);
        // Move the left pointer to the right
        left++;
      }
    }

    // The length of the longest valid window is the total length minus the left pointer
    return s.length() - left;
  }

  public static void main(String[] args) {
    LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();

    String s1 = "ABAB";
    int k1 = 2;
    System.out.println(solution.characterReplacement(s1, k1)); // Output: 4

    String s2 = "AABABBA";
    int k2 = 1;
    System.out.println(solution.characterReplacement(s2, k2)); // Output: 4
  }
}

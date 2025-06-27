package com.murari.striverheet.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/minimum-window-substring
public class MinimumWindowSubString {

  public String minWindow(String s, String t) {
    if (t.length() > s.length()) return "";

    // Create a hashMap to save the frequency of each Character in the target substring t
    Map<Character, Integer> charCountMap = new HashMap<>();
    for (Character ch : t.toCharArray()) {
      charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
    }

    // Create a counter to check how many characters match the target string
    int matchCounter = charCountMap.size();

    // Two pointers for the sliding window
    int left = 0;

    // Variables to keep track of minimum window
    int minLength = Integer.MAX_VALUE;
    int minStart = 0;
    for (int right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);

      // Decrease the frequency of rightChar in the map
      if (charCountMap.containsKey(rightChar)) {
        charCountMap.put(rightChar, charCountMap.get(rightChar) - 1);
        if (charCountMap.get(rightChar) == 0) {
          matchCounter--;
        }
      }

      // Increase the left pointer to maintain the window validity
      while (matchCounter == 0) {
        // Update the minimum window if current window is smaller
        if ((right - left + 1) < minLength) {
          minLength = right - left + 1;
          minStart = left;
        }

        char leftChar = s.charAt(left);
        // Move the left pointer to right and adjust the map and counter
        if (charCountMap.containsKey(leftChar)) {
          charCountMap.put(leftChar, charCountMap.get(leftChar) + 1);
          if (charCountMap.get(leftChar) > 0) {
            matchCounter++;
          }
        }
        left++;
      }
    }
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
  }

  public static void main(String[] args) {
    MinimumWindowSubString solution = new MinimumWindowSubString();

    // Example 1
    String s1 = "ADOBECODEBANC";
    String t1 = "ABC";
    System.out.println(solution.minWindow(s1, t1)); // Output: "BANC"

    // Example 2
    String s2 = "a";
    String t2 = "a";
    System.out.println(solution.minWindow(s2, t2)); // Output: "a"

    // Example 3
    String s3 = "a";
    String t3 = "aa";
    System.out.println(solution.minWindow(s3, t3)); // Output: ""
  }
}

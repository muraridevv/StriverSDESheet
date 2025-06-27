package com.murari.striverheet.arrayspart4;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LengthOfLongestSubstring {
  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int maxSize = 0;

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);

      if (map.containsKey(currentChar)) left = Math.max(map.get(currentChar) + 1, left);
      map.put(currentChar, i);
      maxSize = Math.max(maxSize, i - left + 1);
    }
    return maxSize;
  }

  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
  }
}

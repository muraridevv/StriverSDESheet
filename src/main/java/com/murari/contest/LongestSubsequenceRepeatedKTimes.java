package com.murari.contest;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubsequenceRepeatedKTimes {
  public String longestSubsequenceRepeatedK(String input, int k) {
    String result = "";
    Queue<String> queue = new LinkedList<>();

    for (queue.add(""); !queue.isEmpty(); ) {
      String current = queue.poll();
      for (char ch = 'a'; ch <= 'z'; ch++) {
        String next = current + ch;
        if (isRepeatedKTimes(next, input, k)) {
          result = next;
          queue.add(next);
        }
      }
    }

    return result;
  }

  boolean isRepeatedKTimes(String pattern, String source, int k) {
    int count = 0, i = 0;
    for (char ch : source.toCharArray()) {
      if (ch == pattern.charAt(i)) {
        if (++i == pattern.length()) {
          i = 0;
          if (++count == k) return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    LongestSubsequenceRepeatedKTimes sol = new LongestSubsequenceRepeatedKTimes();
    System.out.println(sol.longestSubsequenceRepeatedK("letsleetcode", 2)); // Output: "let"
    System.out.println(sol.longestSubsequenceRepeatedK("bb", 2)); // Output: "b"
    System.out.println(sol.longestSubsequenceRepeatedK("ab", 2)); // Output: ""
  }
}

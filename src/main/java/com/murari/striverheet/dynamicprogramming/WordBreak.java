package com.murari.striverheet.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  public boolean wordBreakRecursive(String s, List<String> wordDict) {
    return canBreak(s, new HashSet<>(wordDict), 0);
  }

  private boolean canBreak(String s, Set<String> dict, int start) {
    if (start == s.length()) return true;

    for (int end = start + 1; end <= s.length(); end++) {
      String word = s.substring(start, end);
      if (dict.contains(word) && canBreak(s, dict, end)) {
        return true;
      }
    }
    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    Set<String> wordDictSet = new HashSet<>(wordDict);
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    WordBreak wb = new WordBreak();

    String s1 = "leetcode";
    List<String> wordDict1 = Arrays.asList("leet", "code");
    System.out.println(wb.wordBreak(s1, wordDict1)); // Output: true

    String s2 = "applepenapple";
    List<String> wordDict2 = Arrays.asList("apple", "pen");
    System.out.println(wb.wordBreak(s2, wordDict2)); // Output: true

    String s3 = "catsandog";
    List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
    System.out.println(wb.wordBreak(s3, wordDict3)); // Output: false
  }
}

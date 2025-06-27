package com.murari.contest;

public class IsSubsequence {

  public boolean isSubsequence(String s, String t) {
    if (s.isEmpty()) return false;

    int current = 0;
    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) == s.charAt(current)) {
        if (current == s.length() - 1) return true;
        current++;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s = "abc", t = "ahbgdc";
    IsSubsequence obj = new IsSubsequence();
    System.out.println(obj.isSubsequence(s, t));
  }
}

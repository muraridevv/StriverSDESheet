package com.murari.striverheet.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

  public boolean isAnagramUsingMap(String s, String t) {
    if (s.length() != t.length()) return false;

    Map<Character, Integer> freqMap = new HashMap<>();
    for (Character ch : s.toCharArray()) {
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    for (Character ch : t.toCharArray()) {
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) - 1);
    }

    for (Map.Entry<Character, Integer> entryMap : freqMap.entrySet()) {
      if (entryMap.getValue() < 0) return false;
    }
    return true;
  }

  public boolean isAnagramUsingStringBuilder(String s, String t) {
    if (s.length() != t.length()) return false;

    StringBuilder tBuilder = new StringBuilder(t);
    for (Character ch : s.toCharArray()) {
      int tIndex = tBuilder.indexOf(ch.toString());
      if (tIndex != -1) {
        tBuilder.deleteCharAt(tIndex);
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagramUsingArray(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] sFreqArr = new int[26];
    int[] tFreqArr = new int[26];

    for (int i = 0; i < s.length(); i++) {
      sFreqArr[s.charAt(i) - 'a']++;
      tFreqArr[t.charAt(i) - 'a']++;
    }

    return Arrays.equals(sFreqArr, tFreqArr);
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    char[] sCharArr = s.toCharArray();
    char[] tCharArr = t.toCharArray();

    Arrays.sort(sCharArr);
    Arrays.sort(tCharArr);

    for (int i = 0; i < s.length(); i++) {
      if (sCharArr[i] != tCharArr[i]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    ValidAnagram solution = new ValidAnagram();
    String s1 = "anagram", t1 = "nagaram";
    System.out.println("Both string are anagram? : " + solution.isAnagram(s1, t1));

    String s2 = "rat", t2 = "car";
    System.out.println("Both string are anagram? : " + solution.isAnagram(s2, t2));
  }
}

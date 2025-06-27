package com.murari.contest;

import java.util.*;

public class DetermineIfTwoStringsAreClose {
  public boolean closeStrings(String word1, String word2) {
    Map<Character, Integer> freqMap1 = new HashMap<>();
    Map<Character, Integer> freqMap2 = new HashMap<>();
    for (Character ch : word1.toCharArray()) freqMap1.put(ch, freqMap1.getOrDefault(ch, 0) + 1);
    for (Character ch : word2.toCharArray()) freqMap2.put(ch, freqMap2.getOrDefault(ch, 0) + 1);

    if (!freqMap1.keySet().equals(freqMap2.keySet())) return false;

    // Sort frequency counts and compare
    List<Integer> freqList1 = new ArrayList<>(freqMap1.values());
    List<Integer> freqList2 = new ArrayList<>(freqMap2.values());

    Collections.sort(freqList1);
    Collections.sort(freqList2);

    return freqList1.equals(freqList2);
  }

  public static void main(String[] args) {
    DetermineIfTwoStringsAreClose obj = new DetermineIfTwoStringsAreClose();
    //        String word1 = "abc", word2 = "bca";
    //        String word1 = "a", word2 = "aa";
    String word1 = "cabbba", word2 = "aabbss";
    System.out.println(obj.closeStrings(word1, word2));
  }
}

package com.murari.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionString {
  public static List<String> partitionString(String s) {
    List<String> result = new ArrayList<>();
    Set<String> seen = new HashSet<>();

    StringBuilder combination = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      combination.append(s.charAt(i));
      String current = combination.toString();

      if (!seen.contains(current)) {
        seen.add(current);
        result.add(current);
        combination.setLength(0); // reset the combination
      }
    }

    // Handle any leftover combination (optional based on interpretation)
    if (combination.length() > 0 && !seen.contains(combination.toString())) {
      result.add(combination.toString());
    }

    return result;
  }

  public static void main(String[] args) {
    String s1 = "abbccccd";
    String s2 = "aaaa";
    partitionString(s1).forEach(System.out::println);
    //        partitionString(s2).forEach(System.out::println);
  }
}

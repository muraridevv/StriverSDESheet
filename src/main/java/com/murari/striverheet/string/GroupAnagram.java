package com.murari.striverheet.string;

import java.util.*;

//  https://leetcode.com/problems/group-anagrams/
public class GroupAnagram {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<>();
    for (String word : strs) {
      char[] charArr = word.toCharArray();
      Arrays.sort(charArr);
      String key = new String(charArr);

      if (!anagramMap.containsKey(key)) {
        anagramMap.put(key, new ArrayList<>());
      }
      anagramMap.get(key).add(word);
    }
    return new ArrayList<>(anagramMap.values());
  }

  public static void main(String[] args) {
    GroupAnagram solution = new GroupAnagram();
    String[] strs1 = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(solution.groupAnagrams(strs1));
  }
}

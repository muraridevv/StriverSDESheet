package com.murari.contest;

import java.util.*;

public class LongestHarmoniousSubsequences {
  public static int findLHS(int[] nums) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : nums) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
    int maxResult = 0;
    for (Integer key : freqMap.keySet()) {
      if (freqMap.containsKey(key + 1)) {
        maxResult = Math.max(Math.abs(freqMap.get(key) + freqMap.get(key + 1)), maxResult);
      }
    }
    return maxResult;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] {1, 3, 2, 2, 5, 2, 3, 7};
    int[] nums2 = new int[] {1, 2, 3, 4};
    System.out.println(findLHS(nums1));
    System.out.println(findLHS(nums2));
  }
}

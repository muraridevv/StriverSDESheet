package com.murari.contest;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairs {

  public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
    Map<Integer, Integer> countmap = new HashMap<>();
    for (int num : nums2) {
      int key = num * k;
      countmap.put(key, countmap.getOrDefault(key, 0) + 1);
    }

    long count = 0;

    // Iterate over nums1 to find good pairs
    for (int num : nums1) {
      for (int divisor = 1; divisor * divisor <= num; divisor++) {
        if (num % divisor == 0) {
          if (countmap.containsKey(divisor)) {
            count++;
          }

          int correspondingDivisor = num / divisor;
          if (divisor != correspondingDivisor && countmap.containsKey(correspondingDivisor)) {
            count += countmap.get(correspondingDivisor);
          }
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 3, 4};
    int[] nums2 = {1, 3, 4};
    int k = 1;
    System.out.println(numberOfPairs(nums1, nums2, k));
  }
}

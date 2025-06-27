package com.murari.striverheet.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

  public int subarraySumBruteForce(int[] nums, int k) {
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) count++;
      }
    }

    return count;
  }

  public int subarraySum(int[] nums, int k) {
    int count = 0;

    Map<Integer, Integer> freqMap = new HashMap<>();
    freqMap.put(0, 1);
    int sum = 0;

    for (int num : nums) {
      sum += num;
      if (freqMap.containsKey(sum - k)) {
        count += freqMap.get(sum - k);
      }
      freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    SubArraySumEqualsK solution = new SubArraySumEqualsK();

    // Test cases
    System.out.println(solution.subarraySum(new int[] {1, 1, 1}, 2)); // Output: 2
    System.out.println(solution.subarraySum(new int[] {1, 2, 3}, 3)); // Output: 2
  }
}

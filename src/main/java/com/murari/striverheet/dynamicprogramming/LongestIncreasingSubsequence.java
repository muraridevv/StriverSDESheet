package com.murari.striverheet.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  // Using recursion
  public int lengthOfLISRecursion(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    return dfs(nums, Integer.MIN_VALUE, 0);
  }

  private int dfs(int[] nums, int prev, int index) {
    if (index == nums.length) {
      return 0;
    }

    // Case 1. Exclude the current element
    int exclude = dfs(nums, prev, index + 1);

    // Case 2. Include the current element
    int include = 0;
    if (nums[index] > prev) {
      include = 1 + dfs(nums, nums[index], index + 1);
    }

    // Return the maximum length between include and exclude
    return Math.max(include, exclude);
  }

  // Using dp
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    int maxLength = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    int length = lis.lengthOfLIS(nums);
    System.out.println("Length of Longest Increasing Subsequence: " + length);
  }
}

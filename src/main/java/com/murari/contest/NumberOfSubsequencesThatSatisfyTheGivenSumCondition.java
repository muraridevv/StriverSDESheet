package com.murari.contest;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

  private static final int MOD = 1_000_000_007;

  public int numSubseq(int[] nums, int target) {
    int[] power = new int[nums.length];
    int count = 0;
    power[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      power[i] = (power[i - 1] * 2) % MOD;
    }
    Arrays.sort(nums);
    int left = 0, right = nums.length - 1;
    while (left <= right)
      if (nums[left] + nums[right] <= target) {
        count = (count + power[right - left]) % MOD;
        left++;
      } else {
        right--;
      }

    return count;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] {3, 5, 6, 7};
    int[] nums2 = new int[] {3, 3, 6, 8};
    int[] nums3 = new int[] {2, 3, 3, 4, 6, 7};

    NumberOfSubsequencesThatSatisfyTheGivenSumCondition obj =
        new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
    System.out.println(obj.numSubseq(nums1, 9));
    System.out.println(obj.numSubseq(nums2, 10));
    System.out.println(obj.numSubseq(nums3, 12));
  }
}

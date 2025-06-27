package com.murari.contest;

public class MoveZeroes {

  public void moveZeroes(int[] nums) {
    int lastNonZeroIdx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[lastNonZeroIdx] = nums[i];
        lastNonZeroIdx++;
      }
    }
    while (lastNonZeroIdx < nums.length) {
      nums[lastNonZeroIdx] = 0;
      lastNonZeroIdx++;
    }
  }

  public static void main(String[] args) {
    MoveZeroes obj = new MoveZeroes();
    int[] nums = new int[] {0, 1, 0, 3, 12};
    obj.moveZeroes(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }
}

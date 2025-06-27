package com.murari.contest;

public class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int leftSum = 0;
    int rightSum = 0;
    int total = 0;
    for (int num : nums) {
      total += num;
    }

    for (int i = 0; i < nums.length; i++) {

      if ((total - nums[i]) == (2 * leftSum)) return i;
      leftSum += nums[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    FindPivotIndex obj = new FindPivotIndex();
    int[] nums = new int[] {1, 7, 3, 6, 5, 6};
    System.out.println(obj.pivotIndex(nums));
  }
}

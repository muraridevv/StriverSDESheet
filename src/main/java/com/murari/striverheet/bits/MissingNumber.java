package com.murari.striverheet.bits;

public class MissingNumber {

  public int missingNumber(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }

  public static void main(String[] args) {
    MissingNumber missingNumber = new MissingNumber();
    int[] nums = new int[] {0, 1, 2, 4};
    System.out.println(missingNumber.missingNumber(nums));
  }
}

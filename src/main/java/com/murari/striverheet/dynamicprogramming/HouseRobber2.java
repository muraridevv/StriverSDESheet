package com.murari.striverheet.dynamicprogramming;

public class HouseRobber2 {

  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(robUtil(nums, 0, nums.length - 2), robUtil(nums, 1, nums.length - 1));
  }

  public int robUtil(int[] nums, int start, int end) {
    int prevOne = 0;
    int prevTwo = 0;
    for (int i = start; i <= end; i++) {
      int current = Math.max(prevOne, prevTwo + nums[i]);
      prevTwo = prevOne;
      prevOne = current;
    }

    return prevOne;
  }

  public static void main(String[] args) {
    HouseRobber2 houseRobber = new HouseRobber2();
    //        int[] nums = {1,2,3,1};
    //        int[] nums= {2,7,9,3,1};
    //        int[] nums= {2,1,1,2};
    int[] nums = {1};
    int maxAmount = houseRobber.rob(nums);
    System.out.println("Maximum amount robbed: " + maxAmount);
  }
}

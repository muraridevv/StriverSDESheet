package com.murari.contest;

public class IncreasingTripletSubsequence {
  public boolean increasingTriplet(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    return dfs(nums, Integer.MIN_VALUE, 0) >= 3;
  }

  private int dfs(int[] nums, int prev, int index) {
    if (index == nums.length) return 0;

    // Case 1. Exclude the current element
    int exclude = dfs(nums, prev, index + 1);

    // Case 2. Exclude the current element
    int include = 0;
    if (nums[index] > prev) include = 1 + dfs(nums, nums[index], index + 1);
    // Return the max length between include and exclude
    return Math.max(include, exclude);
  }

  public boolean increasingTripletOptimized(int[] nums) {
    int lowest = Integer.MAX_VALUE;
    int secondLowest = Integer.MAX_VALUE;

    for (int num : nums) {
      if (num < lowest) lowest = num;
      else if (num < secondLowest && num > lowest) secondLowest = num;
      else if (num > secondLowest) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();
    //        int[] nums= new int[]{1,2,3,4,5};
    //        int[] nums= new int[]{2,1,5,0,4,6};
    //        int[] nums= new int[]{20,100,10,12,5,13};
    int[] nums =
        new int[] {
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        };
    System.out.println(obj.increasingTripletOptimized(nums));
  }
}

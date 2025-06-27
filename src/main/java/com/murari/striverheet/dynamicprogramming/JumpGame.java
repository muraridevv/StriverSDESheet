package com.murari.striverheet.dynamicprogramming;

public class JumpGame {
  public boolean canJump(int[] nums) {
    int reachableIdx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > reachableIdx) return false;
      reachableIdx = Math.max(reachableIdx, i + nums[i]);
    }
    return true;
  }

  public static void main(String[] args) {
    JumpGame game = new JumpGame();
    int[] nums = new int[] {2, 3, 1, 1, 4};
    System.out.println("It can reach: " + game.canJump(nums));
  }
}

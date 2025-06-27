package com.murari.contest;

// https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    for (int i = 0; i < flowerbed.length; i++) {
      boolean leftAllowed = i == 0 || flowerbed[i - 1] == 0;
      boolean rightAllowed = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

      if (leftAllowed && rightAllowed && flowerbed[i] == 0) {
        flowerbed[i] = 1;
        count++;
      }
    }
    return count >= n;
  }

  public static void main(String[] args) {
    CanPlaceFlowers obj = new CanPlaceFlowers();
    //        int[] flowerbed = new int[]{1,0,0,0,1}; length=5,count+n=3
    //        int[] flowerbed = new int[]{1,0,0,0,1,0};
    int[] flowerbed = new int[] {0, 1, 0};
    int n = 1;
    System.out.println(obj.canPlaceFlowers(flowerbed, n));
  }
}

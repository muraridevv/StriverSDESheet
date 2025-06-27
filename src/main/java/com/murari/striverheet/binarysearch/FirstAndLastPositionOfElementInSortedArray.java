package com.murari.striverheet.binarysearch;

//
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FirstAndLastPositionOfElementInSortedArray {

  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int firstPosition = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] >= target) right = mid - 1;
      else left = mid + 1;

      if (nums[mid] == target) firstPosition = mid;
    }

    left = 0;
    right = nums.length - 1;
    int lastPosition = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] <= target) left = mid + 1;
      else right = mid - 1;

      if (nums[mid] == target) lastPosition = mid;
    }

    return new int[] {firstPosition, lastPosition};
  }

  public static void main(String[] args) {
    FirstAndLastPositionOfElementInSortedArray solution =
        new FirstAndLastPositionOfElementInSortedArray();
    int[] nums = new int[] {5, 7, 7, 8, 8, 10};
    int target = 8;
    int[] result = solution.searchRange(nums, target);
    System.out.println("First: " + result[0] + " Last: " + result[1]);
  }
}

package com.murari.striverheet.binarysearch;

public class MinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    int result = Integer.MAX_VALUE;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      // if left part is sorted
      if (nums[low] <= nums[mid]) {
        result = Math.min(result, nums[low]);

        // elimitate the left half
        low = mid + 1;
      } else {
        result = Math.min(result, nums[mid]);
        high = mid - 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 1, 2};
    MinimumInRotatedSortedArray minimumInRotatedSortedArray = new MinimumInRotatedSortedArray();
    int minimum = minimumInRotatedSortedArray.findMin(nums);
    System.out.print("Minimum element is :" + minimum);
  }
}

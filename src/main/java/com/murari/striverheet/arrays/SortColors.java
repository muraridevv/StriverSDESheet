package com.murari.striverheet.arrays;

import java.util.Arrays;

public class SortColors {
  public void sortColors(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    int mid = 0;
    while (mid <= high) {
      switch (nums[mid]) {
        case 0 -> {
          swap(nums, mid, low);
          low++;
          mid++;
        }
        case 1 -> {
          mid++;
        }
        case 2 -> {
          swap(nums, mid, high);
          high--;
        }
      }
    }
  }

  public void swap(int[] arr, int indx1, int indx2) {
    int temp = arr[indx1];
    arr[indx1] = arr[indx2];
    arr[indx2] = temp;
  }

  public static void main(String[] args) {
    int[] list = new int[] {2, 0, 2, 1, 1, 0};
    //        int [] list=new int[]{0,1,0};
    SortColors obj1 = new SortColors();
    obj1.sortColors(list);
    Arrays.stream(list).forEach(System.out::println);
  }
}

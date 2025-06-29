package com.murari.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSubsequenceOfLengthKWithLargestSum {
  public int[] maxSubsequence(int[] nums, int k) {
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      list.add(new int[] {nums[i], i});
    }
    list.sort((a, b) -> b[0] - a[0]);

    List<Integer> indices = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      indices.add(list.get(i)[1]);
    }
    indices.sort(Comparator.comparingInt(a -> a));

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = nums[indices.get(i)];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] {2, 1, 3, 3};
    int[] nums2 = new int[] {-1, -2, 3, 4};
    int[] nums3 = new int[] {-1, -2, 3, 4};

    FindSubsequenceOfLengthKWithLargestSum obj = new FindSubsequenceOfLengthKWithLargestSum();
    System.out.println(Arrays.toString(obj.maxSubsequence(nums1, 2)));
    System.out.println(Arrays.toString(obj.maxSubsequence(nums2, 3)));
    System.out.println(Arrays.toString(obj.maxSubsequence(nums3, 2)));
  }
}

package com.murari.contest;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (int num : nums1) set1.add(num);
    for (int num : nums2) set2.add(num);

    Set<Integer> diff1 = new HashSet<>(set1);
    Set<Integer> diff2 = new HashSet<>(set2);

    diff1.removeAll(set2);
    diff2.removeAll(set1);

    return Arrays.asList(new ArrayList<>(diff1), new ArrayList<>(diff2));
  }

  public static void main(String[] args) {
    FindTheDifferenceOfTwoArrays obj = new FindTheDifferenceOfTwoArrays();
    int[] nums1 = new int[] {1, 2, 3};
    int[] nums2 = new int[] {2, 4, 6};
    List<List<Integer>> difference = obj.findDifference(nums1, nums2);
    System.out.println(difference);
  }
}

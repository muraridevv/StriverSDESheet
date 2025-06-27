package com.murari.striverheet.arrayspart2;

import java.util.Arrays;

public class MergeSortedArrays {
  /*public static void merge(int[] nums1, int m, int[] nums2, int n) {
      int [] arr=new int[m+n];
      int i=0,j=0;
      for(int k=0;k<m+n;k++){
          if(j>=n || nums1[i]<nums2[j] && i< m  ) arr[k]=nums1[i++];
          else {
              arr[k]=nums2[j++];

          }
      }
      for(int k=0;k<m+n;k++){
          nums1[k]=arr[k];
      }
  }*/

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = nums1.length - 1;

    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[k] = nums1[i];
        k--;
        i--;
      } else {
        nums1[k] = nums2[j];
        k--;
        j--;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[] {2, 5, 6};
    //        int [] nums1=new int[]{4,5,6,0,0,0};
    //        int [] nums2=new int[]{1,2,3};
    merge(nums1, 3, nums2, 3);
    Arrays.stream(nums1).forEach(System.out::println);
  }
}

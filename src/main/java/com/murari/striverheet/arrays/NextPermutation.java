package com.murari.striverheet.arrays;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if(nums==null || nums.length<=1) return;
        int i=nums.length-2;
        // traverse from backwards till we find nums[i] < nums[i+1]
        while (i>=0 && nums[i]>=nums[i+1]) i--;
        //find the just greater element than at index 1
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }

    public static void reverse(int [] arr,int indx1, int indx2){
        while (indx1<indx2) swap(arr, indx1++, indx2--);
    }
    public static void swap(int [] arr,int indx1, int indx2){
        int temp=arr[indx1];
        arr[indx1]=arr[indx2];
        arr[indx2]=temp;
    }

    public static void main(String[] args) {
        int [] list=new int[]{1,3,5,4,2};
        nextPermutation(list);
        Arrays.stream(list).forEach(System.out::println);
    }
}

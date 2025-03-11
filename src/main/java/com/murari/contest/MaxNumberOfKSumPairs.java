package com.murari.contest;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        int count=0;
        int i=0;
        int j=nums.length-1;
        Arrays.sort(nums);
        while(i<j){
            if(nums[i]+nums[j]==k){
                count++;
                i++;
                j--;
            } else if (nums[i]+nums[j]>k) {
                j--;
            } else{
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxNumberOfKSumPairs obj= new MaxNumberOfKSumPairs();
        int[] nums= new int[]{3,1,3,4,3};
        int k= 6;
        System.out.println(obj.maxOperations(nums,k));
    }
}

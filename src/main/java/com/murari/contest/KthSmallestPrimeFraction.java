package com.murari.contest;

import java.util.Arrays;

public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int left=0;
        int right= arr.length-1;
        int count=0;
        while(count<=k){
            double maxLeft= (double) arr[left] /arr[right-1];
            double maxRight= (double) arr[left+1] /arr[right];
            if(maxLeft<maxRight) left++;
            else right--;
            count++;
        }

        return new int[]{0,1};
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction fraction= new KthSmallestPrimeFraction();
        int[] nums= new int[]{1,2,3,5};
        int k=3;
        System.out.println("The "+k+" smallest prime fraction is"+ Arrays.toString(fraction.kthSmallestPrimeFraction(nums, k)));

    }
}

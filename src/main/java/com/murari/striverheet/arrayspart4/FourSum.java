package com.murari.striverheet.arrayspart4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();

        if(nums==null || nums.length==0) return result;

        int n=nums.length;

        Arrays.sort(nums);

        for (int i=0;i<n;i++){
            int target3=target-nums[i];
            for(int j=i+1;j<n;j++){
                long target2=target3-nums[j];

                int front=j+1;
                int back=n-1;

                while (front<back){
                    long twoSum=(nums[front]+nums[back]);
                    if(twoSum<target2)
                        front++;
                    else if (twoSum>target2)
                        back--;
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        result.add(quad);
                        while (front < back && nums[front] == quad.get(2)) front++;
                        while( front > back && nums[back]== quad.get(3)) back--;

                    }
                }
                while (j+1<n && nums[j+1]==nums[j]) j++;
            }
            while (i+1<n && nums[i+1]==nums[i]) i++;
        }
        return result;
    }

    public static void main(String[] args) {
//        int arr[] = {1000000000,1000000000,1000000000,1000000000};
        int arr[] = {1000000000,1000000000,1000000000,1000000000,-1000000000,-1000000000,-1000000000,-1000000000};
        int target = 0;
        System.out.println(fourSum(arr,target));
    }
}

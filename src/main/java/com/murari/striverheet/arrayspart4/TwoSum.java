package com.murari.striverheet.arrayspart4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i< nums.length;i++){
            if(map.containsKey(target-nums[i]))
                return new int[]{i,map.get(target-nums[i])};
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public int[] twoSumUsingPointer(int[] nums, int target) {
        int left=0,right= nums.length-1;
        Arrays.sort(nums);
        for(int i=0; i< nums.length; i++){
            if(nums[left]+ nums[right]==target)
                return new int[]{left,right};
            else if(nums[left]+ nums[right]>target)
                right--;
            else left++;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum twoSumSolver = new TwoSum();

        // Example input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call the twoSum method
        int[] result = twoSumSolver.twoSumUsingPointer(nums, target);

        // Print the result
        if (result.length == 2) {
            System.out.println("Indices of the two numbers: " + Arrays.toString(result));
        } else {
            System.out.println("No solution found.");
        }
    }
}

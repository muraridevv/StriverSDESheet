package com.murari.contest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum= 0;
        for(int i=0;i<k;i++){
            maxSum+=nums[i];
        }
        double currentSum = maxSum;

        for(int i=k; i< nums.length;i++){
            currentSum= currentSum- nums[i-k]+nums[i];
            maxSum= Math.max(currentSum, maxSum);
        }

        double result= maxSum/k;
        return new BigDecimal(result).setScale(5, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        MaximumAverageSubarray1 obj= new MaximumAverageSubarray1();
        int[] nums= new int[]{1,12,-5,-6,50,3};
        int k= 4;
        System.out.println(obj.findMaxAverage(nums, k));
    }
}

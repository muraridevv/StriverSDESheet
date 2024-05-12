package com.murari.striverheet.arrays;

public class KadanesAlgorithm {
    public static int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int [] list=new int[]{-2,-3,4,-1,-2,1,5,-3};
//        int [] list=new int[]{-2};
        System.out.println(maxSubArray(list));

    }
}

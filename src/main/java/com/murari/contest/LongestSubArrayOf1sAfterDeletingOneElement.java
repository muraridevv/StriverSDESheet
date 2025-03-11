package com.murari.contest;

public class LongestSubArrayOf1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int left=0;
        int zeroCount=0;
        int longestSubArray=0;

        for(int right=0; right< nums.length; right++){
            //count the number of zero
            if(nums[right]==0){
                zeroCount++;
            }

            // If more than one zero found, adjust the size
            while(zeroCount>1){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            // Update the maxLength
            longestSubArray= Math.max(longestSubArray, right-left);
        }
        return longestSubArray;
    }

    public static void main(String[] args) {
        LongestSubArrayOf1sAfterDeletingOneElement obj= new LongestSubArrayOf1sAfterDeletingOneElement();
        int [] nums= new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(obj.longestSubarray(nums));
    }
}

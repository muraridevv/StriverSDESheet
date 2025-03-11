package com.murari.contest;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int maxCount=0;
        int zeroCount=0;

        while (right< nums.length){
            // if encounter a zero, count it.
            if(nums[right]==0)
                zeroCount++;

            // If zero count exceeds 'k' move left pointer to reduce window size
            while (zeroCount>k){
                if(nums[left]==0)
                    zeroCount--;
                left++;
            }

            //Update max length of window
            maxCount= Math.max(maxCount, right-left+1);
            right++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes3 obj= new MaxConsecutiveOnes3();
        int [] nums= new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        System.out.println(obj.longestOnes(nums, k));
    }

}

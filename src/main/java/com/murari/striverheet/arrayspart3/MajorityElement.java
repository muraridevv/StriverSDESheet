package com.murari.striverheet.arrayspart3;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int majority=nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]!=majority){
                count--;
                if(count==0){
                    majority=nums[i];
                    count++;
                }
            }else {
                count++;
            }
        }
        return majority;
    }
}

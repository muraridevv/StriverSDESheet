package com.murari.striverheet.arrayspart2;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);

        fast=nums[0];
        while (fast!=slow){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int [] arr=new int[]{2,5,9,6,0,3,8,4,7,1};
        findDuplicate(arr);
    }
}

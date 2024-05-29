package com.murari.striverheet.dynamicprogramming;

public class HouseRobber {

    public int rob(int[] nums) {
        int prevOne=0;
        int prevTwo=0;
        for (int num : nums) {
            int current = Math.max(prevOne, prevTwo + num);
            prevTwo = prevOne;
            prevOne = current;
        }

        return prevOne;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
//        int[] nums = {1,2,3,1};
        int[] nums= {2,7,9,3,1};
//        int[] nums= {2,1,1,2};
        int maxAmount= houseRobber.rob(nums);
        System.out.println("Maximum amount robbed: "+ maxAmount);
    }
}

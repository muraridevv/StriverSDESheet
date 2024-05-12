package com.murari.striverheet.arrayspart4;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(Integer num:nums){
            set.add(num);
        }
        int longestStreak=0;
        for(Integer num: nums){
            if(!set.contains(num-1)){
                int currentNum=num;
                int currentStreak=1;

                while (set.contains(currentNum+1)){
                    currentStreak++;
                    currentNum++;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }

}

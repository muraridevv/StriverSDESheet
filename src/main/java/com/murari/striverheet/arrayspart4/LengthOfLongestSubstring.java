package com.murari.striverheet.arrayspart4;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map= new HashMap<>();
        int left=0;
        int right=0;
        int maxSize=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                left= Math.max(left,map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            maxSize= Math.max(maxSize, right-left+1);
            right++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

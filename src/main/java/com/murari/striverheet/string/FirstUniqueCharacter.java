package com.murari.striverheet.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap= new HashMap<>();
        for(char ch: s.toCharArray()){
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
        }

        for(int i=0; i< s.length(); i++){
            char ch= s.charAt(i);
            if(countMap.get(ch)==1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter uniqueCharacter= new FirstUniqueCharacter();
        System.out.println(uniqueCharacter.firstUniqChar("leetcode"));
        System.out.println(uniqueCharacter.firstUniqChar("loveleetcode"));

    }
}

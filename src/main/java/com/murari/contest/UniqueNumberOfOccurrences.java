package com.murari.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> freqMap= new HashMap<>();
        for(int num: arr){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        Set<Integer> valueSet= new HashSet<>();
        for(int freq: freqMap.values()){
            if(!valueSet.add(freq))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences obj = new UniqueNumberOfOccurrences();
        int [] nums= new int[]{1,2,2,1,1,3};
        System.out.println(obj.uniqueOccurrences(nums));
    }
}

package com.murari.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int countResult=0;
        Map<String,Integer> freqMap= new HashMap<>();
        for(int i=0; i< grid.length;i++){
            int [] key= new int[grid.length];
            for(int j=0; j< grid.length;j++){
                key[j]=grid[j][i];
            }

            freqMap.put(Arrays.toString(key),freqMap.getOrDefault(Arrays.toString(key),0)+1);
        }

        for(int [] row: grid){
            int [] value= new int[grid.length];
            for(int j=0;j< grid.length; j++){
                value[j]=row[j];
            }
            if(freqMap.containsKey(Arrays.toString(value)))
                countResult+=freqMap.get(Arrays.toString(value));
        }
        return countResult;
    }

    public static void main(String[] args) {
        EqualRowAndColumnPairs obj = new EqualRowAndColumnPairs();
//        int [][] grid= new int[][]{{3,2,1},
//                                    {1,7,6},
//                                    {2,7,7}};
        int [][] grid= new int[][]{{3,1,2,2},
                                    {1,4,4,4},
                                    {2,4,2,2},
                                    {2,5,2,2}};
        System.out.println(obj.equalPairs(grid));
    }
}

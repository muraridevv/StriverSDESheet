package com.murari.striverheet.arrayspart2;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int [] i:intervals){
            if(i[0]>end){
                result.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
            else {
                end = Math.max(end, i[1]);
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][2]);

    }




    public static void main(String[] args) {
        int [][]matrix=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int [][]result=merge(matrix);
        for(int i=0;i< result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+", ");
            }
            System.out.println();
        }

    }
}

package com.murari.striverheet.interval;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/insert-interval/
public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> mergedInterval= new ArrayList<>();

        for(int i=0; i< intervals.length; i++){
            //Case 1: Non-overlapping, current interval is completely before new interval
            if(intervals[i][1]< newInterval[0])
                mergedInterval.add(intervals[i]);

            //Case 2: Non-overlapping, current interval is completely after new interval
            else if(intervals[i][0]> newInterval[1]) {
                mergedInterval.add(newInterval);
                newInterval= intervals[i];
            }
            // Case 3: Overlapping
            else {
                newInterval[0]= Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]= Math.max(newInterval[1], intervals[i][1]);
            }
        }

        mergedInterval.add(newInterval);
        return mergedInterval.toArray(new int[mergedInterval.size()][]);



    }

    public int[][] insertUsingWhile(int[][] intervals, int[] newInterval) {
        List<int []> mergedInterval= new ArrayList<>();
        int i=0;

        // Add element before new interval
        while(i< intervals.length && intervals[i][1]<newInterval[0]){
            mergedInterval.add(intervals[i]);
            i++;
        }

        // Add the merged interval
        int mergedStart= newInterval[0];
        int mergedEnd= newInterval[1];
        while(i< intervals.length && intervals[i][0]<= newInterval[1]){
            mergedStart= Math.min(mergedStart, intervals[i][0]);
            mergedEnd= Math.max(mergedEnd, intervals[i][1]);
            i++;
        }
        mergedInterval.add(new int[]{mergedStart, mergedEnd});
        // Add the remaining intervals
        while (i< intervals.length){
            mergedInterval.add(intervals[i]);
            i++;
        }
        // return
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }

    public static void main(String[] args) {
        InsertIntervals solution= new InsertIntervals();
        // Example 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = solution.insert(intervals1, newInterval1);
        for (int[] interval : result1) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();

        // Example 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = solution.insert(intervals2, newInterval2);
        for (int[] interval : result2) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }
}

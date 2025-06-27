package com.murari.striverheet.arrayspart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
    List<int[]> result = new ArrayList<>();
    int start = intervals[0][0];
    int end = intervals[0][1];

    for (int[] interval : intervals) {
      if (interval[0] > end) {
        result.add(new int[] {start, end});
        start = interval[0];
        end = interval[1];
      } else {
        end = Math.max(end, interval[1]);
      }
    }
    result.add(new int[] {start, end});
    return result.toArray(new int[result.size()][]);
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result = merge(matrix);
    for (int[] ints : result) {
      for (int j = 0; j < result[0].length; j++) {
        System.out.print(ints[j] + ", ");
      }
      System.out.println();
    }
  }
}

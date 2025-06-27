package com.murari.striverheet.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

  public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0) return -1;

    int row = grid.length;
    int col = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    int freshCount = 0;

    // Step1. Find all initially rotten oranges and count fresh ones
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 2) queue.offer(new int[] {i, j, 0});
        else if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }
    if (freshCount == 0) return 0; // no fresh oranges to rot
    int timeElapsed = 0;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Step2. BFS to rot adjacent oranges
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int r = current[0], c = current[1], time = current[2];
      timeElapsed = time;

      for (int[] direction : directions) {
        int newRow = r + direction[0];
        int newCol = c + direction[1];

        if (newRow >= 0
            && newRow < row
            && newCol >= 0
            && newCol < col
            && grid[newRow][newCol] == 1) {
          // rot the fresh orange
          grid[newRow][newCol] = 2;
          freshCount--;
          queue.offer(new int[] {newRow, newCol, time + 1});
        }
      }
    }
    return freshCount == 0 ? timeElapsed : -1;
  }

  public static void main(String[] args) {
    RottingOranges sol = new RottingOranges();

    int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println("Output: " + sol.orangesRotting(grid1)); // Output: 4

    int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
    System.out.println("Output: " + sol.orangesRotting(grid2)); // Output: -1

    int[][] grid3 = {{0, 2}};
    System.out.println("Output: " + sol.orangesRotting(grid3)); // Output: 0
  }
}

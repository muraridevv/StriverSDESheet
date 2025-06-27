package com.murari.striverheet.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

  static class Cell {
    int row, col, effort;

    Cell(int row, int col, int effort) {
      this.row = row;
      this.col = col;
      this.effort = effort;
    }
  }

  public int minimumEffortPath(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;

    // Directions: up, down, left, right
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Min heap based on effort
    PriorityQueue<Cell> priorityQueue =
        new PriorityQueue<>(Comparator.comparing(cell -> cell.effort));

    // Matrix to track minimum effort to reach each cell
    int[][] minEfforts = new int[rows][cols];
    for (int[] row : minEfforts) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    priorityQueue.offer(new Cell(0, 0, 0));
    minEfforts[0][0] = 0;

    while (!priorityQueue.isEmpty()) {
      Cell current = priorityQueue.poll();

      if (current.row == rows - 1 && current.col == cols - 1) return current.effort;

      for (int[] direction : directions) {
        int newRow = current.row + direction[0];
        int newCol = current.col + direction[1];

        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
          int currentDiff = Math.abs(heights[current.row][current.col] - heights[newRow][newCol]);
          int maxEffort = Math.max(currentDiff, current.effort);

          if (minEfforts[newRow][newCol] > maxEffort) {
            minEfforts[newRow][newCol] = maxEffort;
            priorityQueue.offer(new Cell(newRow, newCol, maxEffort));
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    PathWithMinimumEffort solver = new PathWithMinimumEffort();

    int[][] h1 = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    System.out.println("Output: " + solver.minimumEffortPath(h1)); // 2

    int[][] h2 = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
    System.out.println("Output: " + solver.minimumEffortPath(h2)); // 1

    int[][] h3 = {
      {1, 2, 1, 1, 1},
      {1, 2, 1, 2, 1},
      {1, 2, 1, 2, 1},
      {1, 2, 1, 2, 1},
      {1, 1, 1, 2, 1}
    };
    System.out.println("Output: " + solver.minimumEffortPath(h3)); // 0
  }
}

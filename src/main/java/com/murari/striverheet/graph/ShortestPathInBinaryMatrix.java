package com.murari.striverheet.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

  public int shortestPathBinaryMatrix(int[][] matrix) {
    int n = matrix.length;
    // If start and end is blocked, return -1
    if (matrix[0][0] != 0 || matrix[n - 1][n - 1] != 0) return -1;

    int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];

    queue.offer(new int[] {0, 0, 1});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int row = cell[0], col = cell[1], dist = cell[2];

      // Reached Destination
      if (row == n - 1 && col == n - 1) return dist;

      for (int[] dir : directions) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];

        if (newRow >= 0
            && newRow < n
            && newCol >= 0
            && newCol < n
            && matrix[newRow][newCol] == 0
            && !visited[newRow][newCol]) {
          queue.offer(new int[] {newRow, newCol, dist + 1});
          visited[newRow][newCol] = true;
        }
      }
    }
    // No path found
    return -1;
  }

  public static void main(String[] args) {
    ShortestPathInBinaryMatrix solver = new ShortestPathInBinaryMatrix();

    //        int[][] grid1 = {{0, 1}, {1, 0}};
    //        System.out.println(solver.shortestPathBinaryMatrix(grid1)); // Output: 2

    //        int[][] grid2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
    //        System.out.println(solver.shortestPathBinaryMatrix(grid2)); // Output: 4
    //
    int[][] grid3 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
    System.out.println(solver.shortestPathBinaryMatrix(grid3)); // Output: -1
  }
}

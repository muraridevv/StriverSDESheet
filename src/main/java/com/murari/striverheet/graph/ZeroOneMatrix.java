package com.murari.striverheet.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
  public int[][] updateMatrix(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;

    int[][] distance = new int[row][col];
    Queue<int[]> queue = new LinkedList<>();

    // Step1: Enqueue all 0 and mark 1 as -1
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 0) {
          distance[i][j] = 0;
          queue.offer(new int[] {i, j});
        } else if (mat[i][j] == 1) {
          distance[i][j] = -1;
        }
      }
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Step2: BFS from all 0s
    while (!queue.isEmpty()) {
      int[] current = queue.poll();

      for (int[] direction : directions) {
        int newRow = current[0] + direction[0];
        int newCol = current[1] + direction[1];

        if (newRow >= 0
            && newRow < row
            && newCol >= 0
            && newCol < col
            && distance[newRow][newCol] == -1) {
          distance[newRow][newCol] = distance[current[0]][current[1]] + 1;
          queue.offer(new int[] {newRow, newCol});
        }
      }
    }
    return distance;
  }

  public static void main(String[] args) {
    ZeroOneMatrix sol = new ZeroOneMatrix();

    int[][] mat1 = {
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}
    };

    int[][] mat2 = {
      {0, 0, 0},
      {0, 1, 0},
      {1, 1, 1}
    };

    System.out.println("Output 1:");
    //        printMatrix(sol.updateMatrix(mat1));

    System.out.println("Output 2:");
    printMatrix(sol.updateMatrix(mat2));
  }

  private static void printMatrix(int[][] mat) {
    for (int[] row : mat) {
      System.out.println(Arrays.toString(row));
    }
  }
}

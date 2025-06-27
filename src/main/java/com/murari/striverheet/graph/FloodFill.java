package com.murari.striverheet.graph;

import java.util.Arrays;

public class FloodFill {

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int originalColor = image[sr][sc];

    // if original color is same as newColor, no need to proceed
    if (originalColor == newColor) return image;

    // perform DFS from the starting pixel
    dfs(image, sr, sc, originalColor, newColor);
    return image;
  }

  private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
    // Check for out of bound conditions and color mismatch
    if (row < 0
        || col < 0
        || row >= image.length
        || col >= image[0].length
        || image[row][col] != originalColor) return;

    image[row][col] = newColor;
    // Visit neighbour
    dfs(image, row - 1, col, originalColor, newColor); // up
    dfs(image, row + 1, col, originalColor, newColor); // down
    dfs(image, row, col - 1, originalColor, newColor); // left
    dfs(image, row, col + 1, originalColor, newColor); // right
  }

  public static void main(String[] args) {
    FloodFill sol = new FloodFill();

    int[][] image1 = {
      {1, 1, 1},
      {1, 1, 0},
      {1, 0, 1}
    };

    int[][] result1 = sol.floodFill(image1, 1, 1, 2);

    System.out.println("Output Image:");
    for (int[] row : result1) {
      System.out.println(Arrays.toString(row));
    }
  }
}

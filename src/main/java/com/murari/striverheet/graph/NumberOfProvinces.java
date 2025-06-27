package com.murari.striverheet.graph;

//  https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    boolean[] isVisited = new boolean[n];
    int provinces = 0;

    for (int i = 0; i < n; i++) {
      if (!isVisited[i]) {
        dfs(i, isConnected, isVisited);
        provinces++;
      }
    }
    return provinces;
  }

  private void dfs(int city, int[][] isConnected, boolean[] isVisited) {
    isVisited[city] = true;

    for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {
      if (isConnected[city][neighbour] == 1 && !isVisited[neighbour])
        dfs(neighbour, isConnected, isVisited);
    }
  }

  public static void main(String[] args) {
    NumberOfProvinces sol = new NumberOfProvinces();

    int[][] isConnected1 = {
      {1, 1, 0},
      {1, 1, 0},
      {0, 0, 1}
    };

    int[][] isConnected2 = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 1}
    };

    System.out.println("Provinces (Example 1): " + sol.findCircleNum(isConnected1)); // Output: 2
    System.out.println("Provinces (Example 2): " + sol.findCircleNum(isConnected2)); // Output: 3
  }
}

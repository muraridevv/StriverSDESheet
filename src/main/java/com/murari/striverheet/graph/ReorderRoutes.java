package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutes {

  public int minReorder(int n, int[][] connections) {

    boolean[] visited = new boolean[n];
    // Initialize adjacency list
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    // Add edges
    // Positive: edge from a to b (original)
    // Negative: edge from b to a (reversed)
    for (int[] conn : connections) {
      adj.get(conn[0]).add(conn[1]);
      adj.get(conn[1]).add(-conn[0]);
    }

    return dfs(adj, visited, 0);
  }

  private int dfs(List<List<Integer>> adj, boolean[] visited, int node) {
    visited[node] = true;
    int changeCount = 0;

    for (int neighbour : adj.get(node)) {
      int absNeighbour = Math.abs(neighbour);
      if (!visited[absNeighbour]) {
        if (neighbour > 0) changeCount++;
        changeCount += dfs(adj, visited, absNeighbour);
      }
    }
    return changeCount;
  }

  public static void main(String[] args) {
    ReorderRoutes sol = new ReorderRoutes();

    int[][] conn1 = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    System.out.println(sol.minReorder(6, conn1)); // Output: 3

    int[][] conn2 = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
    //        System.out.println(sol.minReorder(5, conn2)); // Output: 2
  }
}

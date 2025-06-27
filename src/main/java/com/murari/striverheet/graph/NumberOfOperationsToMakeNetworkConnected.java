package com.murari.striverheet.graph;

public class NumberOfOperationsToMakeNetworkConnected {

  static class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    // find with path compression
    public int find(int node) {
      if (parent[node] != node) {
        parent[node] = find(parent[node]);
      }
      return parent[node];
    }

    // Union by rank
    public boolean union(int u, int v) {
      int rootU = find(u);
      int rootV = find(v);

      if (rootU == rootV) return false; // already connected(extra edge)

      if (rank[rootU] < rank[rootV]) {
        parent[rootU] = rootV;
      } else if (rank[rootU] > rank[rootV]) {
        parent[rootV] = rootU;
      } else {
        parent[rootV] = rootU;
        rank[rootU]++;
      }
      return true;
    }
  }

  public static int makeConnected(int n, int[][] connections) {
    // At least n-1 cables needed to connect all computers
    if (connections.length < n - 1) return -1;

    UnionFind unionFind = new UnionFind(n);
    int component = n;

    for (int[] edge : connections) {
      if (unionFind.union(edge[0], edge[1])) component--;
    }
    return component - 1;
  }

  public static void main(String[] args) {
    int[][] conn1 = {{0, 1}, {0, 2}, {1, 2}};
    int[][] conn2 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
    int[][] conn3 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};

    System.out.println("Example 1: " + makeConnected(4, conn1)); // Output: 1
    System.out.println("Example 2: " + makeConnected(6, conn2)); // Output: 2
    System.out.println("Example 3: " + makeConnected(6, conn3)); // Output: -1
  }
}

package com.murari.striverheet.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemoved {

  static class UnionFind {
    private final Map<Integer, Integer> parent = new HashMap<>();

    public int find(int x) {
      if (!parent.containsKey(x)) {
        parent.put(x, x);
      }
      if (parent.get(x) != x) {
        parent.put(x, find(parent.get(x)));
      }
      return parent.get(x);
    }

    public void union(int u, int v) {
      int rootU = find(u);
      int rootV = find(v);
      if (rootU != rootV) {
        parent.put(rootU, rootV);
      }
    }

    public int count() {
      Set<Integer> roots = new HashSet<>();
      for (int node : parent.keySet()) {
        roots.add(find(node));
      }
      return roots.size();
    }
  }

  public int removeStones(int[][] stones) {
    UnionFind unionFind = new UnionFind();
    for (int[] stone : stones) {
      int row = stone[0];
      int col = ~stone[1]; // Trick: flip bits to avoid collision between rows and column
      unionFind.union(row, col);
    }
    return stones.length - unionFind.count();
  }

  public static void main(String[] args) {
    MostStonesRemoved solver = new MostStonesRemoved();

    int[][] s1 = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
    System.out.println(solver.removeStones(s1)); // Output: 5

    int[][] s2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
    System.out.println(solver.removeStones(s2)); // Output: 3

    int[][] s3 = {{0, 0}};
    System.out.println(solver.removeStones(s3)); // Output: 0
  }
}

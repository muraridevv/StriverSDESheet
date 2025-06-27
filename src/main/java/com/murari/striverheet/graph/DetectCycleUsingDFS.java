package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUsingDFS {

  public boolean hasCycle(int v, List<List<Integer>> adj) {
    boolean[] visited = new boolean[v];

    // check every component
    for (int i = 0; i < v; i++) {
      if (!visited[i]) if (dfs(i, -1, adj, visited)) return true;
    }
    return false;
  }

  private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {

    visited[node] = true;

    for (int neighbour : adj.get(node)) {
      if (!visited[neighbour]) {
        if (dfs(neighbour, node, adj, visited)) return true;
      } else if (neighbour != parent) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    DetectCycleUsingDFS graph = new DetectCycleUsingDFS();

    int V = 5;
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

    // Add edges
    adj.get(0).add(1);
    adj.get(1).add(0);

    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(2).add(3);
    adj.get(3).add(2);

    adj.get(3).add(4);
    adj.get(4).add(3);

    adj.get(4).add(1); // Creates a cycle
    adj.get(1).add(4);

    System.out.println("Cycle present: " + graph.hasCycle(V, adj)); // Output: true
  }
}

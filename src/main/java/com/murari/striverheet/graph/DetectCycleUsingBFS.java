package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUsingBFS {

  public boolean hasCycle(int v, List<List<Integer>> adj) {
    boolean[] visited = new boolean[v];

    // check every component
    for (int i = 0; i < v; i++) {
      if (!visited[i]) if (bfs(i, adj, visited)) return true;
    }
    return false;
  }

  private boolean bfs(int start, List<List<Integer>> adj, boolean[] visited) {
    Queue<int[]> queue = new LinkedList<>(); // [node,parent]
    queue.add(new int[] {start, -1});
    visited[start] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int node = current[0];
      int parent = current[1];

      for (int neighbour : adj.get(node)) {
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.add(new int[] {neighbour, node});
        } else if (neighbour != parent) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    DetectCycleUsingBFS graph = new DetectCycleUsingBFS();

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

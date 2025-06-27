package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {

  public List<Integer> bfsOfGraph(int v, List<List<Integer>> adj) {
    List<Integer> bfs = new ArrayList<>();
    boolean[] visited = new boolean[v];
    Queue<Integer> queue = new LinkedList<>();

    // Start BFS from 0
    queue.add(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      bfs.add(node);

      // Traverse all adjacent vertices of current node
      for (int neighbour : adj.get(node)) {
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.add(neighbour);
        }
      }
    }
    return bfs;
  }

  public static void main(String[] args) {
    // Create adjacency list for 5 vertices
    int V = 5;
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Add undirected edges
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(0).add(4);
    adj.get(4).add(0);
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(1).add(3);
    adj.get(3).add(1);

    // Run BFS
    BFSTraversal solution = new BFSTraversal();
    List<Integer> result = solution.bfsOfGraph(V, adj);

    // Print result
    System.out.println("BFS Traversal:");
    for (int node : result) {
      System.out.print(node + " ");
    }
  }
}

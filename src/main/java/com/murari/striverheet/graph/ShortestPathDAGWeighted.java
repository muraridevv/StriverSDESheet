package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAGWeighted {

  static class Pair {
    int node, weight;

    Pair(int node, int weight) {
      this.node = node;
      this.weight = weight;
    }
  }

  public int[] shortestPath(int N, List<List<Pair>> adj, int src) {
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    Stack<Integer> topo = new Stack<>();
    boolean[] visited = new boolean[N];

    // Topological Sort
    for (int i = 0; i < N; i++) {
      if (!visited[i]) topoSort(i, adj, visited, topo);
    }

    // Relax edges according to topo order
    while (!topo.isEmpty()) {
      int u = topo.pop();
      if (dist[u] != Integer.MAX_VALUE) {
        for (Pair p : adj.get(u)) {
          int v = p.node, wt = p.weight;
          if (dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
          }
        }
      }
    }

    return dist;
  }

  private void topoSort(int node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> stack) {
    visited[node] = true;
    for (Pair p : adj.get(node)) {
      if (!visited[p.node]) {
        topoSort(p.node, adj, visited, stack);
      }
    }
    stack.push(node);
  }

  public static void main(String[] args) {
    int N = 6;
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) adj.add(new ArrayList<>());

    // Directed edges with weights
    adj.get(0).add(new Pair(1, 2));
    adj.get(0).add(new Pair(4, 1));
    adj.get(1).add(new Pair(2, 3));
    adj.get(4).add(new Pair(2, 2));
    adj.get(2).add(new Pair(3, 6));
    adj.get(4).add(new Pair(5, 4));
    adj.get(5).add(new Pair(3, 1));

    int src = 0;
    ShortestPathDAGWeighted sp = new ShortestPathDAGWeighted();
    int[] result = sp.shortestPath(N, adj, src);

    System.out.println("Shortest distances from node " + src + ": " + Arrays.toString(result));
  }
}

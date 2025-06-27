package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
  public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    int[] state = new int[n]; // 0= unvisited, 1= visiting, 2= visited
    List<Integer> safeNodes = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (dfs(i, graph, state)) {
        safeNodes.add(i);
      }
    }
    return safeNodes;
  }

  private boolean dfs(int node, int[][] graph, int[] states) {
    if (states[node] != 0) {
      return states[node] == 2; // already processed
    }

    states[node] = 1; // mark as visiting

    for (int neighbour : graph[node]) {
      if (!dfs(neighbour, graph, states)) {
        return false; // if any path leads to cycle
      }
    }

    states[node] = 2;
    return true;
  }

  public static void main(String[] args) {
    FindEventualSafeStates finder = new FindEventualSafeStates();

    int[][] graph1 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
    System.out.println("Safe Nodes: " + finder.eventualSafeNodes(graph1)); // Output: [2, 4, 5, 6]

    int[][] graph2 = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
    System.out.println("Safe Nodes: " + finder.eventualSafeNodes(graph2)); // Output: [4]
  }
}

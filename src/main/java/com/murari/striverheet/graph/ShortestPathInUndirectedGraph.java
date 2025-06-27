package com.murari.striverheet.graph;

import java.util.*;

public class ShortestPathInUndirectedGraph {

  public int[] shortestPath(int N, List<List<Integer>> adj, int src) {
    int[] distance = new int[N];
    Arrays.fill(distance, Integer.MAX_VALUE);

    Queue<Integer> queue = new LinkedList<>();
    distance[src] = 0;
    queue.offer(src);

    while (!queue.isEmpty()) {
      int node = queue.poll();

      for (int neighbour : adj.get(node)) {
        if (distance[node] + 1 < distance[neighbour]) {
          distance[neighbour] = distance[node] + 1;
          queue.offer(neighbour);
        }
      }
    }
    return distance;
  }

  public static void main(String[] args) {
    int N = 6; // Number of nodes (0 to 5)
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) adj.add(new ArrayList<>());

    // Undirected edges
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(0).add(2);
    adj.get(2).add(0);
    adj.get(1).add(3);
    adj.get(3).add(1);
    adj.get(2).add(4);
    adj.get(4).add(2);
    adj.get(3).add(5);
    adj.get(5).add(3);
    adj.get(4).add(5);
    adj.get(5).add(4);

    int src = 0;
    ShortestPathInUndirectedGraph sp = new ShortestPathInUndirectedGraph();
    int[] distances = sp.shortestPath(N, adj, src);

    System.out.println("Shortest distances from node " + src + ": " + Arrays.toString(distances));
  }
}

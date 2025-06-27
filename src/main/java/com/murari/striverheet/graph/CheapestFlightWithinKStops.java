package com.murari.striverheet.graph;

import java.util.*;

public class CheapestFlightWithinKStops {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] flight : flights) {
      adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
    }
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {src, 0});
    int[] minCost = new int[n];
    Arrays.fill(minCost, Integer.MAX_VALUE);
    int stops = 0;
    while (!q.isEmpty() && stops <= k) {
      int size = q.size();
      while (size-- > 0) {
        int[] curr = q.poll();
        for (int[] neighbour : adj.get(curr[0])) {
          int price = neighbour[1], neighbourNode = neighbour[0];
          if (price + curr[1] >= minCost[neighbourNode]) continue;
          minCost[neighbourNode] = price + curr[1];
          q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
        }
      }
      stops++;
    }
    return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
  }

  public static void main(String[] args) {
    CheapestFlightWithinKStops solver = new CheapestFlightWithinKStops();

    int[][] f1 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
    System.out.println(solver.findCheapestPrice(4, f1, 0, 3, 1)); // Output: 700

    int[][] f2 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    System.out.println(solver.findCheapestPrice(3, f2, 0, 2, 1)); // Output: 200

    int[][] f3 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    System.out.println(solver.findCheapestPrice(3, f3, 0, 2, 0)); // Output: 500
  }
}

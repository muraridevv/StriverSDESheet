package com.murari.striverheet.graph;

import java.util.*;

public class KeysAndRooms {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      Integer current = queue.poll();
      List<Integer> neighbours = rooms.get(current);
      for (Integer neighbour : neighbours) {
        if (!visited[neighbour]) {
          queue.offer(neighbour);
          visited[neighbour] = true;
        }
      }
    }

    for (boolean isVisited : visited) {
      if (!isVisited) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    List<List<Integer>> rooms1 = new ArrayList<>();
    rooms1.add(List.of(1));
    rooms1.add(List.of(2));
    rooms1.add(List.of(3));
    rooms1.add(List.of());

    List<List<Integer>> rooms2 = new ArrayList<>();
    rooms2.add(Arrays.asList(1, 3));
    rooms2.add(Arrays.asList(3, 0, 1));
    rooms2.add(Arrays.asList(2));
    rooms2.add(Arrays.asList(0));

    KeysAndRooms solution = new KeysAndRooms();
    System.out.println(
        "Can visit all rooms (test 1): " + solution.canVisitAllRooms(rooms1)); // Output: true
    System.out.println(
        "Can visit all rooms (test 2): " + solution.canVisitAllRooms(rooms2)); // Output: false
  }
}

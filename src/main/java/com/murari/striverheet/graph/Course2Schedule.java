package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Course2Schedule {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    // build the adjacency list
    for (int[] pre : prerequisites) {
      adj.get(pre[1]).add(pre[0]); // edge: pre[1]-> pre[0]
    }

    boolean[] visited = new boolean[numCourses];
    boolean[] onPath = new boolean[numCourses];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < numCourses; i++) {
      if (!visited[i]) {
        if (!dfs(adj, visited, onPath, stack, i)) return new int[0]; // cycle detected
      }
    }

    int[] result = new int[numCourses];
    int idx = 0;
    while (!stack.isEmpty()) {
      result[idx++] = stack.pop();
    }
    return result;
  }

  private boolean dfs(
      List<List<Integer>> adj,
      boolean[] visited,
      boolean[] onPath,
      Stack<Integer> stack,
      int node) {
    visited[node] = true;
    onPath[node] = true;

    for (int neighbour : adj.get(node)) {
      if (onPath[neighbour]) return false;
      if (!visited[neighbour]) {
        if (!dfs(adj, visited, onPath, stack, neighbour)) return false;
      }
    }
    onPath[node] = false;
    stack.push(node);
    return true;
  }

  public static void main(String[] args) {
    Course2Schedule solver = new Course2Schedule();

    int[][] prereq1 = {{1, 0}};
    //        System.out.println(Arrays.toString(solver.findOrder(2, prereq1))); // [0, 1]

    int[][] prereq2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    System.out.println(Arrays.toString(solver.findOrder(4, prereq2))); // [0, 2, 1, 3] or similar

    int[][] prereq3 = {{0, 1}, {1, 0}};
    //        System.out.println(Arrays.toString(solver.findOrder(2, prereq3))); // [] (cycle)
  }
}

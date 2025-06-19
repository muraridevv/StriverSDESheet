package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {

    private static void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> dfs){
        visited[node]= true;
        dfs.add(node);

        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj, dfs);
            }
        }
    }

    public List<Integer> dfsOfGraph(int v, List<List<Integer>> adj){
        List<Integer> dfs= new ArrayList<>();
        boolean[] visited= new boolean[v];
        dfs(0,visited,adj,dfs);
        return dfs;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Building the undirected graph
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        DFSTraversal sl = new DFSTraversal();
        List<Integer> result = sl.dfsOfGraph(V, adj);

        // Printing DFS result
        System.out.println("DFS Traversal:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}

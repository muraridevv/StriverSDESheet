package com.murari.striverheet.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int length= graph.length;
        int[] color= new int[length];
        Arrays.fill(color,-1);

        //check all components
        for(int i=0; i<length; i++){
            if(color[i]==-1)
                if(!dfsCheck(graph,color,i)) return false;
        }
        return true;
    }

    private boolean dfsCheck(int[][] graph,int[] color, int start){
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        color[start]=0;

        while (!queue.isEmpty()){
            int node= queue.poll();

            for(int neighbour: graph[node]){
                if(color[neighbour]==-1){
                    color[neighbour]=1-color[node];
                    queue.offer(neighbour);
                } else if (color[neighbour]==color[node]) {
                    return false;   //not bipartite
                }
            }
        }
        return true;
    }

    // Utility method for testing
    public static void main(String[] args) {
        BipartiteGraph solution = new BipartiteGraph();

        int[][] graph1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println("Graph 1 is bipartite: " + solution.isBipartite(graph1)); // false

        int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println("Graph 2 is bipartite: " + solution.isBipartite(graph2)); // true
    }
}

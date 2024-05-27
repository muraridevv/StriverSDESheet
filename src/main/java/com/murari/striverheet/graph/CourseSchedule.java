package com.murari.striverheet.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][]prerequisites){
        // Create adjacency list for the graph representation
        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        //Array to track the status of each node( 0= unvisited, 1= visiting, 2= visited)
        int[] visited= new int[numCourses];

        //DFS function to detect cycle
        for(int i=0; i< numCourses; i++){
            if(visited[i]==0){
                if(hasCycle(graph, visited, i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int node){
        if(visited[node]==1){
            return true;    // cycle detected
        }
        if(visited[node]==2){
            return false;   //Already fully visited
        }

        //Mark the node as visiting
        visited[node]=1;
        for(int neighbour: graph.get(node)){
            if(hasCycle(graph, visited, neighbour)){
                return true;
            }
        }

        // Mark the node as fully visited
        visited[node]=2;
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(courseSchedule.canFinish(numCourses1, prerequisites1)); // Output: true

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(courseSchedule.canFinish(numCourses2, prerequisites2)); // Output: false

        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(courseSchedule.canFinish(numCourses3, prerequisites3)); // Output: true
    }
}

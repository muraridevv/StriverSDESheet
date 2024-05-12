package com.murari.striverheet.graph;

import java.util.*;

public class CloneGraph {

    Map<Node, Node> visitedMap= new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;

        if(visitedMap.containsKey(node)){
            return visitedMap.get(node);
        }

        //create copy of current node and add it to map
        Node clone= new Node(node.val, new ArrayList<>());
        visitedMap.put(node, clone);

        //Recursively clone each neighbour of current node and add the cloned neighbour to the
        // neighbour list of copied node
        for (Node neighbour: node.neighbors){
            clone.neighbors.add(cloneGraph(neighbour));
        }

        return clone;

    }

    public static void main(String[] args) {
        CloneGraph cloneGraph= new CloneGraph();

        // Example adjacency list representation of a graph
        List<Node> adjList = new ArrayList<>();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        adjList.add(node1);
        adjList.add(node2);
        adjList.add(node3);
        adjList.add(node4);

        // Clone the graph
        Node clonedNode = cloneGraph.cloneGraph(node1);

        // Print the original and cloned graphs (for verification)
        System.out.println("Original graph:");
        printGraph(adjList);
        System.out.println("\nCloned graph:");
        printGraph(Collections.singletonList(clonedNode));
    }

    private static void printGraph(List<Node> nodes) {
        for (Node node : nodes) {
            System.out.print("Node " + node.val + ": ");
            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor.val + " ");
            }
            System.out.println();
        }
    }
}

package DataStructures.NonLinear.Graph.BreadthForSearch;

import java.util.*;

public class GraphBFS {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list representation

    // Constructor
    public GraphBFS(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // BFS traversal starting from source vertex
    public void BFS(int source) {
        // Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);
        
        System.out.println("Breadth First Traversal starting from vertex " + source + ":");

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            source = queue.poll();
            System.out.print(source + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, mark it visited and enqueue it
            for (Integer neighbor : adjacencyList[source]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(6);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        
        // Perform BFS starting from vertex 0
        g.BFS(0);
    }
}
package DataStructures.NonLinear.Graph.DepthForSearch;
import java.util.*;


public class code {
    // Graph class implementation with Depth-First Search
    static class Graph {
        private Map<Integer, List<Integer>> adjacencyList;
        
        public Graph() {
            adjacencyList = new HashMap<>();
        }
        
        public void addVertex(int vertex) {
            adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        }
        
        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
        }
        
        public void addEdgeUndirected(int source, int destination) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }
        
        // Recursive DFS
        public void dfs(int startVertex) {
            Set<Integer> visited = new HashSet<>();
            dfsRecursive(startVertex, visited);
        }
        
        private void dfsRecursive(int vertex, Set<Integer> visited) {
            visited.add(vertex);
            System.out.print(vertex + " ");
            
            for (int adjacent : adjacencyList.getOrDefault(vertex, Collections.emptyList())) {
                if (!visited.contains(adjacent)) {
                    dfsRecursive(adjacent, visited);
                }
            }
        }
        
        // Iterative DFS using stack
        public void dfsIterative(int startVertex) {
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            
            stack.push(startVertex);
            
            while (!stack.isEmpty()) {
                int vertex = stack.pop();
                
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    System.out.print(vertex + " ");
                    
                    List<Integer> neighbors = adjacencyList.getOrDefault(vertex, Collections.emptyList());
                    for (int i = neighbors.size() - 1; i >= 0; i--) {
                        int adjacent = neighbors.get(i);
                        if (!visited.contains(adjacent)) {
                            stack.push(adjacent);
                        }
                    }
                }
            }
        }
        
        public void printGraph() {
            for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
                System.out.print(entry.getKey() + " -> ");
                System.out.println(entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        
        // Add vertices
        for (int i = 0; i < 7; i++) {
            graph.addVertex(i);
        }
        
        // Add edges for sample graph
        graph.addEdgeUndirected(0, 1);
        graph.addEdgeUndirected(0, 2);
        graph.addEdgeUndirected(1, 3);
        graph.addEdgeUndirected(1, 4);
        graph.addEdgeUndirected(2, 5);
        graph.addEdgeUndirected(2, 6);
        
        System.out.println("Graph representation:");
        graph.printGraph();
        
        System.out.println("\nDFS Recursive:");
        graph.dfs(0);
        
        System.out.println("\n\nDFS Iterative:");
        graph.dfsIterative(0);
    }
}

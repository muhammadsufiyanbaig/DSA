package Algorithms.KruskalAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class code {
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge otherEdge) {
            return this.weight - otherEdge.weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.kruskalMST();
    }

    static class Graph {
        int vertices;
        List<Edge> edges;

        public Graph(int vertices) {
            this.vertices = vertices;
            edges = new ArrayList<>();
        }

        void addEdge(int source, int destination, int weight) {
            edges.add(new Edge(source, destination, weight));
        }

        void kruskalMST() {
            List<Edge> result = new ArrayList<>();
            
            Collections.sort(edges);
            DisjointSet ds = new DisjointSet(vertices);
            
            int edgeCount = 0;
            int i = 0;
            
            while (edgeCount < vertices - 1 && i < edges.size()) {
                Edge nextEdge = edges.get(i++);
                
                int x = ds.find(nextEdge.source);
                int y = ds.find(nextEdge.destination);
                
                if (x != y) {
                    result.add(nextEdge);
                    ds.union(x, y);
                    edgeCount++;
                }
            }
            
            System.out.println("Edges in the minimum spanning tree:");
            int totalWeight = 0;
            for (Edge edge : result) {
                System.out.println(edge.source + " -- " + edge.destination + " == " + edge.weight);
                totalWeight += edge.weight;
            }
            System.out.println("Total MST weight: " + totalWeight);
        }
    }
}

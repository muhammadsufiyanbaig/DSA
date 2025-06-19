# Breadth-First Search (BFS)

## Introduction
Breadth-First Search is a graph traversal algorithm that explores all vertices at the current depth level before moving on to vertices at the next depth level. This makes BFS particularly useful for finding the shortest path in unweighted graphs.

## How BFS Works

1. Start from a source vertex and mark it as visited
2. Explore all adjacent vertices of the current vertex
3. For each adjacent vertex, if not yet visited:
    - Mark it as visited
    - Add it to the queue for later exploration
4. Move to the next vertex in the queue and repeat

## Algorithm

```
BFS(graph, start_vertex):
     // Create a queue for BFS
     queue = new Queue()
     
     // Mark the start vertex as visited and enqueue it
     visited[start_vertex] = true
     queue.enqueue(start_vertex)
     
     while queue is not empty:
          // Dequeue a vertex from queue
          current = queue.dequeue()
          
          // Process the current vertex (e.g., print it)
          process(current)
          
          // Get all adjacent vertices of the dequeued vertex
          // If an adjacent vertex has not been visited, mark it
          // visited and enqueue it
          for each neighbor in graph.adjacentVertices(current):
                if visited[neighbor] == false:
                     visited[neighbor] = true
                     queue.enqueue(neighbor)
```

## Implementation

```java
import java.util.*;

public class BreadthFirstSearch {
    // BFS traversal from a given source vertex
    public static void bfs(Map<String, List<String>> graph, String start) {
        // Create a queue for BFS
        Queue<String> queue = new LinkedList<>();
        
        // Mark the source node as visited and enqueue it
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            String vertex = queue.poll();
            System.out.print(vertex + " ");
            
            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent has not been visited, mark it visited and enqueue it
            for (String neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Example graph representation using adjacency lists
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B", "F"));
        graph.put("F", Arrays.asList("C", "E"));
        
        System.out.println("BFS traversal starting from vertex 'A':");
        bfs(graph, "A");
    }
}
```

## Complexity Analysis

- **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges.
- **Space Complexity**: O(V), where V is the number of vertices.

## Applications

- Shortest path in an unweighted graph
- Web crawlers
- Social networking websites (finding people within a certain connection distance)
- Garbage collection (Cheney's algorithm)
- Finding connected components
- Testing bipartiteness of a graph
- GPS navigation systems
- Network broadcasting

## Advantages and Disadvantages

### Advantages
- Guarantees shortest path in unweighted graphs
- Good for searching vertices closer to the source
- Uses less memory for wide graphs compared to DFS

### Disadvantages
- May use more memory for deep graphs compared to DFS
- Not suitable for decision trees and game trees
- May be slower than DFS for specific problems

## Comparison with Depth-First Search

| Feature | BFS | DFS |
|---------|-----|-----|
| Data Structure | Queue | Stack |
| Memory | More (proportional to width) | Less (proportional to depth) |
| Solution | Optimal (shortest path) | May not be optimal |
| Completeness | Complete | Complete only for finite depth |
| Use case | Shortest path, level order traversal | Topological sorting, maze generation |

## Further Reading

- [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition) by Cormen, Leiserson, Rivest, and Stein
- [Graph Algorithms](https://www.cambridge.org/core/books/graph-algorithms/0526E49144D207C35762196B85AF93A2) by Shimon Even
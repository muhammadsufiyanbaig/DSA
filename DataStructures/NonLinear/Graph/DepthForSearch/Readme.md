# Depth-First Search (DFS)

## Introduction

Depth-First Search (DFS) is a fundamental graph traversal algorithm that explores as far as possible along each branch before backtracking. This README provides an implementation and explanation of DFS in Java.

## How DFS Works

DFS traverses a graph by:

1. Starting at a chosen vertex
2. Exploring as far as possible along each branch before backtracking
3. Marking vertices as "visited" to avoid cycles
4. Using either recursion or a stack data structure for implementation

## Implementation in Java

### Graph Representation

```java
import java.util.*;

class Graph {
    private int V;                  // Number of vertices
    private LinkedList<Integer>[] adj;  // Adjacency list

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
```

### Recursive DFS Implementation

```java
public void dfsRecursive(int startVertex) {
    boolean[] visited = new boolean[V];
    dfsUtil(startVertex, visited);
}

private void dfsUtil(int vertex, boolean[] visited) {
    // Mark the current node as visited
    visited[vertex] = true;
    System.out.print(vertex + " ");

    // Recur for all adjacent vertices
    for (Integer neighbor : adj[vertex]) {
        if (!visited[neighbor]) {
            dfsUtil(neighbor, visited);
        }
    }
}
```

### Iterative DFS Implementation

```java
public void dfsIterative(int startVertex) {
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();
    
    // Push the start vertex
    stack.push(startVertex);
    
    while (!stack.empty()) {
        // Pop a vertex from the stack
        int vertex = stack.pop();
        
        // If not visited, visit it
        if (!visited[vertex]) {
            System.out.print(vertex + " ");
            visited[vertex] = true;
        }
        
        // Get all adjacent vertices
        // Push unvisited neighbors to stack (in reverse order to match recursive DFS)
        ListIterator<Integer> it = adj[vertex].listIterator(adj[vertex].size());
        while (it.hasPrevious()) {
            int neighbor = it.previous();
            if (!visited[neighbor]) {
                stack.push(neighbor);
            }
        }
    }
}
```

## Time and Space Complexity

- **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges.
- **Space Complexity**: O(V) for the visited array and recursion stack/stack data structure.

## Applications of DFS

- Topological sorting
- Finding connected components
- Maze solving problems
- Cycle detection in graphs
- Path finding algorithms
- Solving puzzles with only one solution

## Example Usage

```java
public static void main(String[] args) {
    // Create a graph with 8 vertices
    Graph g = new Graph(8);
    
    // Add edges
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(2, 5);
    g.addEdge(2, 6);
    g.addEdge(6, 7);
    
    System.out.println("Depth First Traversal (starting from vertex 0):");
    g.dfsRecursive(0);
    
    System.out.println("\n\nDepth First Traversal (iterative, starting from vertex 0):");
    g.dfsIterative(0);
}
```

## DFS vs BFS

- DFS generally requires less memory than BFS
- DFS is better suited for problems where we need to find solutions far from the source
- BFS is preferable when finding the shortest path in unweighted graphs

## Further Reading

- [DFS on GeeksforGeeks](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/)
- [Algorithms by Robert Sedgewick](https://algs4.cs.princeton.edu/40graphs/)
- [Introduction to Algorithms (CLRS)](https://mitpress.mit.edu/books/introduction-algorithms-third-edition)
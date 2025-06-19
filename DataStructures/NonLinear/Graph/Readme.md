# Graph Data Structure

## Introduction
Graphs are mathematical structures used to model pairwise relationships between objects. A graph is made up of vertices (also called nodes) which are connected by edges. Graphs are one of the most versatile and powerful data structures in computer science, enabling the representation and solution of many real-world problems.

## Basic Terminology

- **Graph (G)**: A graph G consists of a set of vertices V and a set of edges E, denoted as G = (V, E).
- **Vertex/Node**: An entity in the graph, often represented as a point or circle.
- **Edge**: A connection between two vertices, represented as a line.
- **Adjacent Vertices**: Two vertices are adjacent if there's an edge connecting them.
- **Degree of a Vertex**: Number of edges connected to a vertex.
- **Path**: A sequence of vertices where each adjacent pair is connected by an edge.
- **Cycle**: A path where the first and last vertices are the same.
- **Connected Graph**: A graph where there's a path between every pair of vertices.
- **Disconnected Graph**: A graph that is not connected.
- **Component**: A connected subgraph of a disconnected graph.
- **Subgraph**: A graph whose vertices and edges are subsets of another graph.
- **Weight**: A value assigned to an edge, representing cost, distance, capacity, etc.
- **Neighborhood**: All vertices adjacent to a given vertex.

## Types of Graphs

### By Direction
- **Undirected Graph**: Edges have no direction.
- **Directed Graph (Digraph)**: Edges have direction (arrows).

### By Weight
- **Weighted Graph**: Edges have associated weights/values.
- **Unweighted Graph**: Edges do not have weights.

### By Structure
- **Complete Graph**: Every vertex is connected to every other vertex.
- **Bipartite Graph**: Vertices can be divided into two sets, with edges only between sets.
- **Tree**: A connected, undirected graph with no cycles.
- **DAG (Directed Acyclic Graph)**: Directed graph with no cycles.
- **Multigraph**: Graph that allows multiple edges between the same vertices.
- **Simple Graph**: No self-loops or multiple edges.

## Graph Representations

### Adjacency Matrix
```
    A B C D
A [0,1,1,0]
B [1,0,0,1]
C [1,0,0,1]
D [0,1,1,0]
```
- Space complexity: O(V²)
- Good for dense graphs
- Quick to check if two vertices are adjacent: O(1)

### Adjacency List
```
A -> B -> C
B -> A -> D
C -> A -> D
D -> B -> C
```
- Space complexity: O(V+E)
- Better for sparse graphs
- Finding adjacent vertices is efficient

### Edge List
```
[(A,B), (A,C), (B,D), (C,D)]
```
- Simple representation
- Used for algorithms like Kruskal's

## Common Graph Algorithms

### Graph Traversal
- **Breadth-First Search (BFS)**: Explores all neighbors before moving to next level
- **Depth-First Search (DFS)**: Explores as far as possible along a branch before backtracking

### Shortest Path Algorithms
- **Dijkstra's Algorithm**: For graphs with non-negative weights
- **Bellman-Ford Algorithm**: Handles negative weights
- **Floyd-Warshall Algorithm**: Finds shortest paths between all vertex pairs

### Minimum Spanning Tree
- **Kruskal's Algorithm**: Grows forest by adding minimum-weight edges
- **Prim's Algorithm**: Grows a single tree from a starting vertex

### Connectivity
- **Connected Components**: Find all connected subgraphs
- **Strongly Connected Components**: For directed graphs (Kosaraju's, Tarjan's algorithms)

### Cycle Detection
- DFS-based cycle detection
- Union-Find data structure

### Topological Sorting
- Ordering vertices such that for every edge (u,v), u comes before v
- Applicable only to DAGs

## Real-world Applications

- **Social Networks**: Representing relationships between people
- **Routing Algorithms**: Finding shortest paths in road networks, IP routing
- **Web Crawling**: The internet is a massive graph
- **Recommendation Systems**: Suggesting products, friends, content
- **Dependency Resolution**: Package managers, build systems
- **Biological Networks**: Protein interactions, genetic pathways
- **Circuit Design**: Electronic components and connections
- **Scheduling Problems**: Task dependencies and allocation
- **Geographic Information Systems**: Maps and navigation
- **Machine Learning**: Graph neural networks, knowledge graphs

## Implementation Considerations

- Choose representation based on graph density and required operations
- For large graphs, consider specialized graph databases
- Parallelization can speed up many graph algorithms
- External memory algorithms for graphs that don't fit in RAM
- Dynamic graphs require specific data structures for efficient updates

## Complexity Analysis

| Algorithm | Time Complexity | Space Complexity |
|-----------|----------------|-----------------|
| BFS       | O(V+E)         | O(V)            |
| DFS       | O(V+E)         | O(V)            |
| Dijkstra  | O(E+V log V)*  | O(V)            |
| Bellman-Ford | O(VE)       | O(V)            |
| Floyd-Warshall | O(V³)     | O(V²)           |
| Kruskal   | O(E log E)     | O(V+E)          |
| Prim      | O(E+V log V)*  | O(V)            |

*With binary heap implementation

## References and Further Reading

- "Introduction to Algorithms" by Cormen, Leiserson, Rivest, and Stein
- "Algorithms" by Robert Sedgewick and Kevin Wayne
- "Algorithm Design" by Jon Kleinberg and Éva Tardos
- [Stanford Graph Algorithms Course](https://www.coursera.org/specializations/algorithms)
- [NetworkX Documentation](https://networkx.org/) (Python library for graph analysis)
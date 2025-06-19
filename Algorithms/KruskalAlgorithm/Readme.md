# Kruskal's Algorithm

## Introduction
Kruskal's algorithm is a minimum spanning tree algorithm that finds an edge of the least possible weight that connects any two trees in a forest. It is a greedy algorithm in graph theory used for finding a minimum spanning tree for a connected weighted undirected graph.

## Algorithm Overview

Kruskal's algorithm works as follows:
1. Sort all edges in non-decreasing order of their weight
2. Initialize result as empty set
3. For each edge in sorted order:
    - If including this edge doesn't form a cycle, include it in result
    - Otherwise discard it
4. Return the result, which forms the MST

## Time Complexity
- Sorting edges: O(E log E)
- Processing edges (using Union-Find): O(E log V)
- Overall complexity: O(E log E) or O(E log V) where E is number of edges and V is number of vertices

## Pseudocode
```
function KruskalMST(graph):
     MST = empty set
     sort edges of graph in ascending order by weight
     initialize disjoint-set data structure
     for each vertex v in graph:
          makeSet(v)
     for each edge (u, v) in sorted edges:
          if find(u) != find(v):
                add edge (u, v) to MST
                union(u, v)
     return MST
```

## Applications
- Network design
- Approximation algorithms for NP-hard problems
- Cluster analysis
- Image segmentation

## Implementation
A key component of Kruskal's algorithm is the efficient implementation of the disjoint-set data structure (Union-Find) with optimizations like path compression and union by rank.

## Example
Consider a graph with vertices A, B, C, D and edges:
- A-B with weight 1
- B-C with weight 3
- C-D with weight 1
- D-A with weight 4
- A-C with weight 5
- B-D with weight 2

Kruskal's algorithm would select edges: A-B, C-D, and B-D, resulting in a MST with total weight 4.
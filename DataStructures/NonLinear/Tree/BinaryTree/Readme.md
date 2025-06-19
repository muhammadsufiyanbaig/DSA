# Binary Tree Data Structure

## Table of Contents
- [Introduction](#introduction)
- [Types of Binary Trees](#types-of-binary-trees)
- [Binary Tree Operations](#binary-tree-operations)
- [Tree Traversal Methods](#tree-traversal-methods)
- [Implementation](#implementation)
- [Time and Space Complexity](#time-and-space-complexity)
- [Applications](#applications)
- [Advantages and Disadvantages](#advantages-and-disadvantages)
- [Usage Examples](#usage-examples)
- [Contributing](#contributing)

## Introduction

A **Binary Tree** is a hierarchical data structure where each node has at most two children, referred to as the left child and right child. It's one of the most fundamental data structures in computer science and forms the basis for many other advanced data structures.

### Key Characteristics:
- Each node contains data and references to at most two child nodes
- The topmost node is called the **root**
- Nodes with no children are called **leaves**
- The **height** of a tree is the longest path from root to leaf
- The **depth** of a node is its distance from the root

## Types of Binary Trees

### 1. Full Binary Tree (Strictly Binary Tree)
- **Definition**: Every node has either 0 or 2 children
- **Properties**: 
  - No node has exactly 1 child
  - Number of leaf nodes = Number of internal nodes + 1
- **Use Case**: Expression trees, decision trees

```
       A
     /   \
    B     C
   / \   / \
  D   E F   G
```

### 2. Complete Binary Tree
- **Definition**: All levels are filled except possibly the last level, which is filled from left to right
- **Properties**: 
  - Used in heap implementations
  - Can be efficiently stored in arrays
  - Height = ⌊log₂(n)⌋
- **Use Case**: Binary heaps, priority queues

```
       A
     /   \
    B     C
   / \   /
  D   E F
```

### 3. Perfect Binary Tree
- **Definition**: All internal nodes have exactly 2 children and all leaves are at the same level
- **Properties**: 
  - Total nodes = 2^h - 1 (where h is height)
  - Number of leaf nodes = 2^(h-1)
- **Use Case**: Theoretical analysis, optimal balanced structures

```
       A
     /   \
    B     C
   / \   / \
  D   E F   G
```

### 4. Balanced Binary Tree
- **Definition**: Height difference between left and right subtrees is at most 1 for every node
- **Properties**: 
  - Ensures O(log n) operations
  - Self-balancing variants exist
- **Use Case**: Database indexing, search operations
- **Examples**: AVL trees, Red-Black trees

### 5. Binary Search Tree (BST)
- **Definition**: Left subtree contains values less than root, right subtree contains values greater than root
- **Properties**: 
  - Inorder traversal gives sorted sequence
  - Average case O(log n) operations
  - Can degrade to O(n) if unbalanced
- **Use Case**: Searching, sorting, database indexing

```
       8
     /   \
    3     10
   / \      \
  1   6      14
     / \    /
    4   7  13
```

### 6. Degenerate Binary Tree (Pathological Tree)
- **Definition**: Each internal node has only one child
- **Properties**: 
  - Essentially a linked list
  - Height = n-1 (worst case)
  - Poor performance for most operations
- **Use Case**: Represents worst-case scenario

```
A
 \
  B
   \
    C
     \
      D
```

### 7. Skewed Binary Tree
- **Left-Skewed**: Only left children exist
- **Right-Skewed**: Only right children exist
- **Properties**: Similar to degenerate tree, poor performance

### 8. Threaded Binary Tree
- **Definition**: Null pointers are replaced with threads pointing to inorder predecessor/successor
- **Types**: 
  - Single Threaded (only right threads)
  - Double Threaded (both left and right threads)
- **Use Case**: Efficient traversal without recursion or stack

## Binary Tree Operations

### Basic Operations:
1. **Insertion**: Add a new node to the tree
2. **Deletion**: Remove a node from the tree
3. **Search**: Find a specific value in the tree
4. **Traversal**: Visit all nodes in a specific order

### Advanced Operations:
1. **Height Calculation**: Find the maximum depth
2. **Size Calculation**: Count total number of nodes
3. **Level Order Traversal**: Visit nodes level by level
4. **Balancing**: Restructure tree for optimal performance

## Tree Traversal Methods

### 1. Depth-First Search (DFS)

#### Inorder Traversal (Left → Root → Right)
- **Process**: Visit left subtree, process root, visit right subtree
- **Result**: For BST, gives sorted sequence
- **Use Case**: Getting sorted data from BST

#### Preorder Traversal (Root → Left → Right)
- **Process**: Process root, visit left subtree, visit right subtree
- **Use Case**: Creating copy of tree, prefix expressions

#### Postorder Traversal (Left → Right → Root)
- **Process**: Visit left subtree, visit right subtree, process root
- **Use Case**: Deleting tree, postfix expressions, calculating directory sizes

### 2. Breadth-First Search (BFS)

#### Level Order Traversal
- **Process**: Visit nodes level by level from left to right
- **Implementation**: Uses queue data structure
- **Use Case**: Finding shortest path, serialization

## Implementation

The implementation includes:
- Node class with data and child references
- Insertion and deletion methods
- All traversal methods
- Search functionality
- Utility methods (height, size, etc.)

### Key Methods:
```java
public void insert(int data)           // Insert new node
public void delete(int data)           // Delete node
public boolean search(int key)         // Search for value
public void inOrder()                  // Inorder traversal
public void preOrder()                 // Preorder traversal
public void postOrder()                // Postorder traversal
public void levelOrder()               // Level order traversal
public int height()                    // Calculate height
public int countNodes()                // Count total nodes
```

## Time and Space Complexity

### Binary Search Tree (Average Case):
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Search    | O(log n)       | O(log n)         |
| Insertion | O(log n)       | O(log n)         |
| Deletion  | O(log n)       | O(log n)         |
| Traversal | O(n)           | O(log n)         |

### Binary Search Tree (Worst Case - Skewed):
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Search    | O(n)           | O(n)             |
| Insertion | O(n)           | O(n)             |
| Deletion  | O(n)           | O(n)             |
| Traversal | O(n)           | O(n)             |

### Balanced Binary Tree:
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Search    | O(log n)       | O(log n)         |
| Insertion | O(log n)       | O(log n)         |
| Deletion  | O(log n)       | O(log n)         |
| Traversal | O(n)           | O(log n)         |

## Applications

### 1. Database Systems
- **B-trees and B+ trees** for database indexing
- **Binary search trees** for in-memory indexing
- **Query optimization** using tree structures

### 2. File Systems
- **Directory structures** represented as trees
- **File allocation tables** using tree-based indexing
- **Compression algorithms** (Huffman coding trees)

### 3. Expression Evaluation
- **Parse trees** for mathematical expressions
- **Abstract syntax trees** in compilers
- **Decision trees** in machine learning

### 4. Network Routing
- **Routing tables** using tree structures
- **Shortest path algorithms** with tree representation
- **Network topology** modeling

### 5. Gaming and AI
- **Game trees** for chess, tic-tac-toe
- **Decision trees** for AI decision making
- **Scene graphs** in 3D graphics

## Advantages and Disadvantages

### Advantages:
- **Efficient searching** in balanced trees: O(log n)
- **Dynamic size** - can grow and shrink during runtime
- **Ordered traversal** - inorder gives sorted sequence for BST
- **Flexible structure** - can represent hierarchical data
- **Memory efficient** - no wasted space like arrays

### Disadvantages:
- **Can become unbalanced** leading to O(n) operations
- **No constant time access** to arbitrary elements
- **Extra memory overhead** for storing pointers
- **Complex deletion** operation with multiple cases
- **Not cache-friendly** due to pointer-based structure

## Usage Examples

### Creating and Using Binary Tree:
```java
// Create a new binary tree
BinaryTree tree = new BinaryTree();

// Insert values
tree.insert(50);
tree.insert(30);
tree.insert(70);
tree.insert(20);
tree.insert(40);
tree.insert(60);
tree.insert(80);

// Perform operations
tree.inOrder();           // Output: 20 30 40 50 60 70 80
System.out.println("Height: " + tree.height());  // Output: Height: 3
System.out.println("Search 40: " + tree.search(40));  // Output: true

// Delete a node
tree.delete(30);
tree.inOrder();           // Output: 20 40 50 60 70 80
```

### Common Use Cases:
1. **Implementing a phone book** with efficient search
2. **Creating a file system** directory structure
3. **Building a calculator** with expression trees
4. **Implementing auto-complete** functionality
5. **Creating decision trees** for machine learning

## Best Practices

1. **Choose the right type**: Use balanced trees for frequent operations
2. **Handle edge cases**: Check for null nodes and empty trees
3. **Consider iterative approaches**: For very deep trees to avoid stack overflow
4. **Use appropriate traversal**: Choose based on your use case
5. **Implement proper deletion**: Handle all three cases correctly
6. **Monitor tree balance**: Consider self-balancing trees for critical applications

## Related Data Structures

- **AVL Tree**: Self-balancing binary search tree
- **Red-Black Tree**: Another self-balancing BST
- **B-Tree**: Generalized binary tree for databases
- **Heap**: Complete binary tree with heap property
- **Trie**: Tree for storing strings efficiently
- **Segment Tree**: For range query operations

## Contributing

Contributions are welcome! Please feel free to submit pull requests, report bugs, or suggest improvements.

### How to Contribute:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request


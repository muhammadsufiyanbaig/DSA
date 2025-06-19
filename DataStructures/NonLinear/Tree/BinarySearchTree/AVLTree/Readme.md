# AVL Tree

## Introduction
An AVL tree is a self-balancing binary search tree where the height difference between left and right subtrees of any node (the balance factor) is at most 1. This balance ensures operations like search, insertion, and deletion maintain O(log n) time complexity in both average and worst cases.

## History
Named after its inventors, Georgy Adelson-Velsky and Evgenii Landis, who introduced this data structure in their 1962 paper "An algorithm for the organization of information."

## Properties
- Every node maintains a balance factor (height of left subtree - height of right subtree)
- Balance factor must be -1, 0, or 1 for all nodes
- All operations preserve the binary search tree property: left < node < right
- Height of an AVL tree with n nodes is always O(log n)
- Maximum number of nodes in an AVL tree of height h is more than a complete binary tree but less than a perfect binary tree

## Operations

### Insertion
1. Perform standard BST insertion
2. Update heights of ancestors
3. Check balance factor and perform rotations if needed:
    - Left-Left Case: Right rotation
    - Right-Right Case: Left rotation
    - Left-Right Case: Left rotation followed by Right rotation
    - Right-Left Case: Right rotation followed by Left rotation

### Deletion
1. Perform standard BST deletion
2. Update heights of ancestors
3. Check balance factor and rebalance using rotations if needed

### Searching
Same as in a binary search tree - O(log n) time complexity

## Balancing Mechanism

### Rotations
AVL trees maintain balance through four types of rotations:

#### Right Rotation (LL Case)
```
     z                                      y 
    / \                                   /   \
  y   T4      Right Rotation (z)        x     z
 / \          - - - - - - - - ->      /  \   /  \ 
x   T3                               T1  T2 T3  T4
/ \
T1 T2
```

#### Left Rotation (RR Case)
```
  z                                y
 /  \                            /   \ 
T1   y     Left Rotation(z)     z     x
     /  \   - - - - - - - ->    / \   / \
    T2   x                     T1 T2 T3 T4
         / \
        T3 T4
```

#### Left-Right Rotation (LR Case)
Left rotation on subtree root's left child, followed by right rotation on subtree root

#### Right-Left Rotation (RL Case)
Right rotation on subtree root's right child, followed by left rotation on subtree root

## Time Complexity
- Search: O(log n)
- Insert: O(log n)
- Delete: O(log n)

## Applications
- Databases for maintaining sorted data
- In-memory sets and maps implementations in many libraries
- Network routing algorithms
- File system organization
- Machine learning algorithms (like k-dimensional trees)

## Advantages and Disadvantages

### Advantages
- Guaranteed O(log n) time complexity for operations
- Self-balancing property ensures optimal tree height
- More rigid balance than Red-Black trees (potentially faster lookups)
- No additional color storage required (unlike Red-Black trees)

### Disadvantages
- Extra space for storing height/balance factor
- More rotations during insertions and deletions compared to Red-Black trees
- Complex implementation due to various rotation cases
- Higher constant factors for insertion and deletion

## Implementation Considerations
- Each node typically stores:
  - Key/value
  - Left child pointer
  - Right child pointer
  - Height/balance factor
- Balance factor can be calculated as: height(left) - height(right)
- Recursive implementation is often cleaner but iterative versions can be more efficient

## Example Code Structure
```
class Node {
     int key;
     Node left, right;
     int height;
}

class AVLTree {
     Node root;
     
     // Utility methods
     int height(Node N)
     int getBalance(Node N)
     
     // Rotations
     Node rightRotate(Node y)
     Node leftRotate(Node x)
     
     // Operations
     Node insert(Node node, int key)
     Node delete(Node root, int key)
     boolean search(Node root, int key)
     
     // Traversals
     void inOrder(Node node)
}
```
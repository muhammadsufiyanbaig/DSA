package DataStructures.NonLinear.Tree.BinarySearchTree.AVLTree;

public class code {
    // Node class for AVL Tree
    static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.height = 1; // New node is initially at height 1
            left = right = null;
        }
    }

    // AVL Tree implementation
    static class AVLTree {
        private Node root;

        public AVLTree() {
            root = null;
        }

        // Get the height of the node
        private int height(Node N) {
            if (N == null)
                return 0;
            return N.height;
        }

        // Get the balance factor of the node
        private int getBalance(Node N) {
            if (N == null)
                return 0;
            return height(N.left) - height(N.right);
        }

        // Right rotate subtree rooted with y
        private Node rightRotate(Node y) {
            Node x = y.left;
            Node T2 = x.right;

            // Perform rotation
            x.right = y;
            y.left = T2;

            // Update heights
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            // Return new root
            return x;
        }

        // Left rotate subtree rooted with x
        private Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;

            // Perform rotation
            y.left = x;
            x.right = T2;

            // Update heights
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            // Return new root
            return y;
        }

        // Insert a value into the AVL tree
        public void insert(int data) {
            root = insertRec(root, data);
        }

        private Node insertRec(Node node, int data) {
            if (node == null) {
                return new Node(data);
            }

            if (data < node.data) {
                node.left = insertRec(node.left, data);
            } else if (data > node.data) {
                node.right = insertRec(node.right, data);
            } else {
                return node; // Duplicate values are not allowed in BST
            }

            // Update height of this node
            node.height = 1 + Math.max(height(node.left), height(node.right));

            // Get the balance factor to check whether this node became unbalanced
            int balance = getBalance(node);

            // Left Left Case
            if (balance > 1 && data < node.left.data)
                return rightRotate(node);

            // Right Right Case
            if (balance < -1 && data > node.right.data)
                return leftRotate(node);

            // Left Right Case
            if (balance > 1 && data > node.left.data) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right Left Case
            if (balance < -1 && data < node.right.data) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }
    }
}

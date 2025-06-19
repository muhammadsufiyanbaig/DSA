package DataStructures.NonLinear.Tree.BinaryTree;

public class BinaryTree {
    // Node class for Binary Tree
    class Node {
        int data;
        Node left, right;
        
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Binary Tree class implementation
    private Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive insert function
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        
        return root;
    }

    // Delete a node
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
        if (root == null) return root;

        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Find minimum value node in a subtree
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Inorder traversal (Left, Root, Right)
    public void inOrder() {
        System.out.print("InOrder: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Preorder traversal (Root, Left, Right)
    public void preOrder() {
        System.out.print("PreOrder: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Postorder traversal (Left, Right, Root)
    public void postOrder() {
        System.out.print("PostOrder: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Search for a key
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        
        if (key < root.data)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    // Calculate height of the tree
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) return 0;
        
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count total nodes
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) return 0;
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }

    // Check if tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Level order traversal (Breadth-First)
    public void levelOrder() {
        System.out.print("Level Order: ");
        if (root == null) return;
        
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        System.out.println("Binary Tree Operations:");
        System.out.println("Tree height: " + tree.height());
        System.out.println("Total nodes: " + tree.countNodes());
        
        // Traversals
        tree.inOrder();
        tree.preOrder();
        tree.postOrder();
        tree.levelOrder();
        
        // Search operations
        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 25: " + tree.search(25));
        
        // Delete operation
        System.out.println("\nAfter deleting 20:");
        tree.delete(20);
        tree.inOrder();
        
        System.out.println("After deleting 30:");
        tree.delete(30);
        tree.inOrder();
        
        System.out.println("After deleting 50:");
        tree.delete(50);
        tree.inOrder();
    }
}
package DataStructures.NonLinear.Tree.BinarySearchTree;

public class code {
    // Node class for the binary search tree
    static class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Binary Search Tree implementation
    static class BinarySearchTree {
        Node root;
        
        public BinarySearchTree() {
            root = null;
        }
        
        // Insert a value
        public void insert(int data) {
            root = insertRec(root, data);
        }
        
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
        
        // Search a value
        public boolean search(int data) {
            return searchRec(root, data);
        }
        
        private boolean searchRec(Node root, int data) {
            if (root == null)
                return false;
            if (root.data == data)
                return true;
            
            return (data < root.data) 
                ? searchRec(root.left, data) 
                : searchRec(root.right, data);
        }
        
        // Delete a value
        public void delete(int data) {
            root = deleteRec(root, data);
        }
        
        private Node deleteRec(Node root, int data) {
            if (root == null) return null;
            
            if (data < root.data)
                root.left = deleteRec(root.left, data);
            else if (data > root.data)
                root.right = deleteRec(root.right, data);
            else {
                // Node with one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;
                
                // Node with two children
                root.data = minValue(root.right);
                root.right = deleteRec(root.right, root.data);
            }
            
            return root;
        }
        
        private int minValue(Node root) {
            int minValue = root.data;
            while (root.left != null) {
                minValue = root.left.data;
                root = root.left;
            }
            return minValue;
        }
        
        // In-order traversal
        public void inOrderTraversal() {
            inOrderTraversal(root);
            System.out.println();
        }
        
        private void inOrderTraversal(Node root) {
            if (root != null) {
                inOrderTraversal(root.left);
                System.out.print(root.data + " ");
                inOrderTraversal(root.right);
            }
        }
        
        // Main method to test the BST
        public static void main(String[] args) {
            BinarySearchTree tree = new BinarySearchTree();
            
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);
            
            System.out.println("Inorder traversal:");
            tree.inOrderTraversal();
            
            System.out.println("Searching for 40: " + tree.search(40));
            System.out.println("Searching for 100: " + tree.search(100));
            
            System.out.println("Deleting 40");
            tree.delete(40);
            System.out.println("Inorder traversal after deletion:");
            tree.inOrderTraversal();
        }
    }
}

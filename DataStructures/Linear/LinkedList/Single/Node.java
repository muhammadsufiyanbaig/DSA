package DataStructures.Linear.LinkedList.Single;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList {
    private Node head;

    public SingleLinkedList() {
        this.head = null;
    }

    // Add element at the beginning of the list
    public void pushFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add element at the end of the list
    public void pushBack(int data) {
        Node newNode = new Node(data);

        // If list is empty, make the new node as head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Change the next of last node to new node
        last.next = newNode;
    }

    // Search for an element in the list
    public boolean search(int key) {
        Node current = head;

        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Delete a node with given key
    public void deleteNode(int key) {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of the previous node
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    // Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}

// Main method for testing
class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        // Add elements
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushFront(0);

        System.out.println("Original List:");
        list.printList();

        // Search for elements
        System.out.println("Search for 2: " + list.search(2));
        System.out.println("Search for 5: " + list.search(5));

        // Delete an element
        list.deleteNode(2);
        System.out.println("List after deleting 2:");
        list.printList();

        // Reverse the list
        list.reverse();
        System.out.println("Reversed List:");
        list.printList();
    }
}
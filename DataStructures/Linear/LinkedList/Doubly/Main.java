package DataStructures.Linear.LinkedList.Doubly;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add element at the beginning of the list
    public void pushFront(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add element at the end of the list
    public void pushBack(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;

        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

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
        // If list is empty
        if (head == null) {
            return;

        }

        // If head contains the key
        if (head.data == key) {
            head = head.next;

            // If only one node was present

            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            return;
        }

        // If tail contains the key
        if (tail.data == key) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Search for the key in the middle of the list
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        // If key was not found
        if (current == null) {
            return;
        }

        // Unlink the node from the list
        current.prev.next = current.next;

        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    // Reverse the doubly linked list
    public void reverse() {
        if (head == null || head == tail) {
            return;
        }

        Node current = head;
        Node temp = null;

        // Swap next and prev pointers for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        // Swap head and tail
        temp = head;
        head = tail;
        tail = temp;
    }

    // Print the doubly linked list (forward)
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Print the doubly linked list (backward)
    public void printListBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Main method for testing

}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Add elements
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        list.pushFront(0);

        System.out.println("Original List (forward):");
        list.printList();

        System.out.println("Original List (backward):");
        list.printListBackward();

        // Search for elements
        System.out.println("Search for 2: " + list.search(2));
        System.out.println("Search for 5: " + list.search(5));

        // Delete an element
        list.deleteNode(2);
        System.out.println("List after deleting 2 (forward):");
        list.printList();

        // Reverse the list
        list.reverse();
        System.out.println("Reversed List (forward):");
        list.printList();

        System.out.println("Reversed List (backward):");
        list.printListBackward();
    }
}

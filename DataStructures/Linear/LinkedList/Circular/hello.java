package DataStructures.Linear.LinkedList.Circular;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void pushFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node last = head;
        while (last.next != head) {
            last = last.next;
        }

        newNode.next = head;
        last.next = newNode;
        head = newNode;
    }

    public void pushBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node last = head;
        while (last.next != head) {
            last = last.next;
        }

        last.next = newNode;
        newNode.next = head;
    }

    public boolean search(int key) {
        if (head == null) return false;

        Node current = head;
        do {
            if (current.data == key) return true;
            current = current.next;
        } while (current != head);

        return false;
    }

    public void deleteNode(int key) {
        if (head == null) return;

        if (head.next == head && head.data == key) {
            head = null;
            return;
        }

        if (head.data == key) {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            return;
        }

        Node current = head, prev = null;
        while (current.next != head) {
            if (current.data == key) break;
            prev = current;
            current = current.next;
        }

        if (current.data == key && prev != null) {
            prev.next = current.next;
        }
    }

    public void reverse() {
        if (head == null || head.next == head) return;

        Node prev = null, current = head, next;
        Node oldHead = head;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        head = prev;
        oldHead.next = head;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class hello {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Insert elements
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushFront(0);

        System.out.println("Original List:");
        list.printList();

        System.out.println("Search for 2: " + list.search(2));
        System.out.println("Search for 5: " + list.search(5));

        list.deleteNode(2);
        System.out.println("List after deleting 2:");
        list.printList();

        list.reverse();
        System.out.println("Reversed List:");
        list.printList();
    }
}

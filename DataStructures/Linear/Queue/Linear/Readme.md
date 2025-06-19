# Linear Queue

A linear queue is a fundamental data structure that follows the First-In-First-Out (FIFO) principle, where the first element added is the first one to be removed.

## Characteristics
- Sequential collection of elements
- Insertions occur at the rear end
- Deletions occur at the front end
- FIFO (First-In-First-Out) behavior

## Basic Operations
- **Enqueue**: Adds an element to the rear of the queue
- **Dequeue**: Removes an element from the front of the queue
- **Front/Peek**: Returns the element at the front without removing it
- **isEmpty**: Checks if the queue is empty
- **isFull**: Checks if the queue is full (for array-based implementations)

## Implementation

### Array Implementation
```java
class Queue {
    private static final int MAX_SIZE = 100;
    private int[] items = new int[MAX_SIZE];
    private int front, rear;
    
    public Queue() {
        front = -1;
        rear = -1;
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }
    
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        if (front == -1) front = 0;
        rear++;
        items[rear] = element;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int element = items[front];
        if (front >= rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return element;
    }
}
```

### Linked List Implementation
```java
class Node {
    public int data;
    public Node next;
    
    public Node(int value) {
        data = value;
        next = null;
    }
}

class Queue {
    private Node front;
    private Node rear;
    
    public Queue() {
        front = null;
        rear = null;
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        Node temp = front;
        int element = temp.data;
        front = front.next;
        if (front == null) rear = null;
        return element;
    }
}
```

## Limitations of Linear Queue
When implemented using arrays, linear queues have a major drawback: after repeated enqueue and dequeue operations, the usable space at the beginning of the array cannot be reused, leading to "false overflow" conditions.

## Applications
- CPU scheduling
- Disk scheduling
- IO Buffers
- Pipes
- Call center phone systems
- Print queue management

## Time Complexity
- Enqueue: O(1)
- Dequeue: O(1)
- Front/Peek: O(1)
- isEmpty/isFull: O(1)
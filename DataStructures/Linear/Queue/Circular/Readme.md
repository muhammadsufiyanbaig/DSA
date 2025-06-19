# Circular Queue Implementation Using Array

## Introduction
A circular queue is a linear data structure that follows the FIFO (First In First Out) principle and is implemented using a circular array. Unlike a simple queue, a circular queue efficiently utilizes memory by reusing spaces that become empty after dequeuing operations.

## How Circular Queue Works
In a circular queue:
- The queue has a fixed size array
- Two pointers are maintained: `front` and `rear`
- `front` points to the first element of the queue
- `rear` points to the last element of the queue
- Initially both `front` and `rear` point to -1 (empty queue)
- When elements are added/removed, the pointers move in a circular manner

## Operations

### Basic Operations
1. **Enqueue**: Add an element to the rear of the queue
2. **Dequeue**: Remove an element from the front of the queue
3. **Front**: Get the front element without removing it
4. **IsEmpty**: Check if the queue is empty
5. **IsFull**: Check if the queue is full

### Conditions
- **Empty**: `front == -1`
- **Full**: `(rear + 1) % size == front`
- **Circular Behavior**: When a pointer reaches the end, it wraps around to the beginning

## Advantages
- Better memory utilization compared to a linear queue
- No need to shift elements when dequeuing
- Efficient for fixed-size queue implementations

## Disadvantages
- Fixed size (can't grow dynamically)
- Slightly more complex implementation than a linear queue

## Implementation Details

```java
class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    
    public CircularQueue(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
        capacity = size;
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
    
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        queue[rear] = data;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Assuming -1 as an error code
        }
        int data = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return data;
    }
    
    public int frontElement() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Assuming -1 as an error code
        }
        return queue[front];
    }
}
```

## Time & Space Complexity
- **Time Complexity**: O(1) for all operations (enqueue, dequeue, front, isEmpty, isFull)
- **Space Complexity**: O(n) where n is the size of the queue

## Applications
- CPU scheduling
- Memory management
- Traffic management
- Serving requests on a shared resource

## Summary
A circular queue efficiently uses memory by reusing spaces and is ideal for applications with fixed-size queue requirements where elements are repeatedly added and removed.
# Priority Queue

A Priority Queue is a special type of queue where elements are processed based on their priority rather than the order of arrival. In Java, it's implemented through the `PriorityQueue` class which is part of the `java.util` package.

## Table of Contents

- [Introduction](#introduction)
- [Implementation](#implementation)
- [Basic Operations](#basic-operations)
- [Example Code](#example-code)
- [Time Complexity](#time-complexity)
- [Use Cases](#use-cases)

## Introduction

By default, the `PriorityQueue` in Java orders elements according to their natural ordering. For custom objects, you need to provide a `Comparator` to determine the priority.

## Implementation

```java
import java.util.PriorityQueue;
import java.util.Comparator;

// Default (min heap) priority queue
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max heap priority queue using comparator
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

// Custom comparator for objects
PriorityQueue<Task> taskQueue = new PriorityQueue<>((a, b) -> a.getPriority() - b.getPriority());
```

## Basic Operations

- `add(E e)` / `offer(E e)` - Inserts an element into the queue
- `peek()` - Retrieves but does not remove the highest priority element
- `poll()` - Retrieves and removes the highest priority element
- `remove(Object o)` - Removes a specific element
- `size()` - Returns the number of elements
- `isEmpty()` - Checks if queue is empty

## Example Code

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add elements
        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(5);
        
        // Print the queue (note: ordering in toString() doesn't reflect priority)
        System.out.println("Queue: " + pq);
        
        // Process elements by priority
        System.out.println("Processing elements by priority:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
```

### Custom Object Example

```java
import java.util.PriorityQueue;

class Patient {
    private String name;
    private int priority;
    
    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    public int getPriority() { return priority; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return name + " (priority: " + priority + ")";
    }
}

public class HospitalQueue {
    public static void main(String[] args) {
        // Lower number = higher priority
        PriorityQueue<Patient> emergencyRoom = new PriorityQueue<>((p1, p2) -> p1.getPriority() - p2.getPriority());
        
        emergencyRoom.add(new Patient("John", 2));
        emergencyRoom.add(new Patient("Mark", 1)); // Highest priority
        emergencyRoom.add(new Patient("Steven", 5));
        emergencyRoom.add(new Patient("Alice", 3));
        
        System.out.println("Treating patients in priority order:");
        while (!emergencyRoom.isEmpty()) {
            System.out.println("Treating: " + emergencyRoom.poll());
        }
    }
}
```

## Time Complexity

- **Insertion (offer)**: O(log n)
- **Deletion (poll)**: O(log n)
- **Peek (peek)**: O(1)
- **Search (contains)**: O(n)

## Use Cases

- Task scheduling based on priority
- Dijkstra's shortest path algorithm
- Huffman coding algorithm
- Event-driven simulation
- Job scheduling in operating systems
- Emergency room patient management

## Implementation Notes

The `PriorityQueue` in Java is typically implemented using a binary heap data structure, which provides efficient priority-based operations.
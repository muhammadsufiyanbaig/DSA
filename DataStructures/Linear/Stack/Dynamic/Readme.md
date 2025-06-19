# Dynamic Stack

A dynamic stack is an implementation of the stack data structure that can grow or shrink in size during runtime as elements are added or removed.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Operations](#operations)
- [Implementation](#implementation)
- [Time and Space Complexity](#time-and-space-complexity)
- [Usage Example](#usage-example)
- [Advantages](#advantages)
- [Disadvantages](#disadvantages)

## Introduction

Unlike a static stack which has a fixed capacity determined at initialization, a dynamic stack allocates memory dynamically as needed. This eliminates the problem of stack overflow (as long as memory is available) and uses memory more efficiently.

## Features

- **Dynamic Memory Allocation**: The stack can grow as needed
- **Automatic Resizing**: Stack size increases when full and decreases when mostly empty
- **LIFO (Last-In-First-Out)**: Follows the standard stack principle

## Operations

- **Push**: Add an element to the top of the stack
- **Pop**: Remove the topmost element from the stack
- **Peek/Top**: View the topmost element without removing it
- **isEmpty**: Check if the stack is empty
- **Size**: Get the current number of elements in the stack

## Implementation

A dynamic stack is typically implemented using:

1. **Dynamic Arrays**: Initial array with resize operations when needed
2. **Linked Lists**: Naturally dynamic structure where each node contains data and a pointer to the next node

### Dynamic Array Implementation

```java
import java.util.EmptyStackException;

class DynamicStack<T> {
    private T[] array;
    private int capacity;
    private int topIndex;
    
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i <= topIndex; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
    }
    
    @SuppressWarnings("unchecked")
    public DynamicStack(int initialCapacity) {
        capacity = initialCapacity;
        array = (T[]) new Object[capacity];
        topIndex = -1;
    }
    
    public DynamicStack() {
        this(10); // Default initial capacity
    }
    
    public void push(T element) {
        if (topIndex + 1 == capacity) {
            resize(capacity * 2);  // Double the capacity
        }
        array[++topIndex] = element;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        T element = array[topIndex--];
        
        // Shrink the array if it's less than 25% full
        if (topIndex + 1 < capacity / 4 && capacity > 10) {
            resize(capacity / 2);
        }
        
        return element;
    }
    
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[topIndex];
    }
    
    public boolean isEmpty() {
        return topIndex == -1;
    }
    
    public int size() {
        return topIndex + 1;
    }
}
```

## Time and Space Complexity

- **Space Complexity**: O(n)
- **Time Complexity**:
  - Push: O(1) amortized
  - Pop: O(1) amortized
  - Peek/Top: O(1)
  - isEmpty: O(1)
  - Size: O(1)

Amortized analysis considers the occasional resize operations that take O(n) time.

## Usage Example

```java
public class DynamicStackExample {
    public static void main(String[] args) {
        DynamicStack<Integer> stack = new DynamicStack<>();
        
        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element: " + stack.top());  // Output: 30
        System.out.println("Stack size: " + stack.size());  // Output: 3
        
        // Pop elements
        System.out.println("Popped: " + stack.pop());  // Output: 30
        System.out.println("Popped: " + stack.pop());  // Output: 20
        
        System.out.println("Stack size after pops: " + stack.size());  // Output: 1
    }
}
```

## Advantages

- No fixed size limitation
- Efficient memory usage
- No overflow issues (unless system memory is exhausted)
- Ability to handle varying amounts of data

## Disadvantages

- Slightly higher overhead from memory management
- Occasional resize operations can cause performance spikes
- More complex implementation than static stacks

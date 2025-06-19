# Static Stack Implementation

A comprehensive guide to implementing stacks with static memory allocation.

## Table of Contents
- [Introduction](#introduction)
- [What is a Static Stack?](#what-is-a-static-stack)
- [Operations](#operations)
- [Implementation](#implementation)
- [Advantages and Disadvantages](#advantages-and-disadvantages)
- [Time Complexity](#time-complexity)
- [Use Cases](#use-cases)

## Introduction
In computer science, a stack is a linear data structure that follows the Last In, First Out (LIFO) principle. Static stacks are implementations of stacks using fixed-size arrays.

## What is a Static Stack?
A static stack is a stack implementation where the maximum size is determined at compile time. It uses a fixed-size array to store elements and maintains a pointer to the top element.

## Operations
- **Push**: Add an element to the top of the stack
- **Pop**: Remove the top element from the stack
- **Peek/Top**: View the top element without removing it
- **isEmpty**: Check if the stack is empty
- **isFull**: Check if the stack is at maximum capacity

## Implementation
Here's a basic implementation in C:

```java
public class Stack {
    private static final int MAX_SIZE = 100;
    private int[] array;
    private int top;
    
    public Stack() {
        array = new int[MAX_SIZE];
        top = -1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }
    
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        array[++top] = value;
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return array[top--];
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return array[top];
    }
}
```

## Advantages and Disadvantages

### Advantages
- Simple implementation
- Memory efficient for known, fixed-size requirements
- Fast operations (O(1) time complexity)
- No memory allocation overhead during operations

### Disadvantages
- Fixed maximum size
- Possibility of stack overflow
- Inefficient memory usage if actual stack size is much smaller than allocated size

## Time Complexity
- Push: O(1)
- Pop: O(1)
- Peek: O(1)
- isEmpty: O(1)
- isFull: O(1)

## Use Cases
- Expression evaluation and syntax parsing
- Function call management (call stack)
- Undo mechanisms in applications
- Backtracking algorithms
- Any application where the maximum stack size is predictable

Static stacks are ideal for environments with limited memory resources or where the maximum stack size can be determined beforehand.
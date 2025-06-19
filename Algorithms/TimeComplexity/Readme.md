# Time Complexity

## Table of Contents
- [Introduction](#introduction)
- [Asymptotic Notations](#asymptotic-notations)
    - [Big O Notation](#big-o-notation)
    - [Omega Notation](#omega-notation)
    - [Theta Notation](#theta-notation)
- [Common Time Complexities](#common-time-complexities)
- [Analyzing Algorithms](#analyzing-algorithms)
- [Comparison of Time Complexities](#comparison-of-time-complexities)
- [Best Practices](#best-practices)
- [Resources](#resources)

## Introduction

Time complexity is a fundamental concept in algorithm analysis that measures the amount of computational time required by an algorithm to run as a function of the input size. It helps us understand how the runtime of an algorithm scales with input size without relying on implementation details or hardware specifications.

## Asymptotic Notations

### Big O Notation

Big O notation (O) represents the upper bound of an algorithm's time complexity, indicating the worst-case scenario.

- **Definition**: f(n) ∈ O(g(n)) if there exist positive constants c and n₀ such that 0 ≤ f(n) ≤ c×g(n) for all n ≥ n₀.
- **Usage**: Used to describe the maximum time an algorithm will take.

### Omega Notation

Omega notation (Ω) represents the lower bound of an algorithm's time complexity, indicating the best-case scenario.

- **Definition**: f(n) ∈ Ω(g(n)) if there exist positive constants c and n₀ such that 0 ≤ c×g(n) ≤ f(n) for all n ≥ n₀.
- **Usage**: Used to describe the minimum time an algorithm will take.

### Theta Notation

Theta notation (Θ) represents both the upper and lower bounds of an algorithm's time complexity, indicating the average-case scenario.

- **Definition**: f(n) ∈ Θ(g(n)) if f(n) ∈ O(g(n)) and f(n) ∈ Ω(g(n)).
- **Usage**: Used when the upper and lower bounds match.

## Common Time Complexities

Here are common time complexities in order of efficiency (from most efficient to least efficient):

| Notation | Name | Description | Example |
|----------|------|-------------|---------|
| O(1) | Constant | Runtime is constant regardless of input size | Array index access |
| O(log n) | Logarithmic | Runtime grows logarithmically with input size | Binary search |
| O(n) | Linear | Runtime grows linearly with input size | Linear search |
| O(n log n) | Log-linear | Runtime grows log-linearly | Efficient sorting algorithms (Merge sort, Heap sort) |
| O(n²) | Quadratic | Runtime is proportional to square of input size | Bubble sort, Insertion sort |
| O(n³) | Cubic | Runtime is proportional to cube of input size | Some matrix operations |
| O(2ⁿ) | Exponential | Runtime doubles with each additional input element | Recursive Fibonacci, Traveling Salesman |
| O(n!) | Factorial | Runtime grows factorially with input size | Brute force Traveling Salesman |

## Analyzing Algorithms

To determine the time complexity of an algorithm:

1. **Identify the basic operations**: Determine what operations are performed repeatedly
2. **Count the number of operations**: Express the count as a function of input size
3. **Apply simplification rules**: Eliminate constants and lower-order terms
4. **Determine the asymptotic notation**: Express using Big O, Omega, or Theta notation

### Example Analysis

```java
// Time Complexity: O(n)
public static int findMax(int[] arr) {
    int maxValue = arr[0];  // O(1)
    for (int i = 1; i < arr.length; i++) {  // Loops n-1 times
        if (arr[i] > maxValue) {  // O(1) comparison
            maxValue = arr[i];  // O(1) assignment
        }
    }
    return maxValue;  // O(1)
}
```

## Comparison of Time Complexities

![Time Complexity Graph](https://upload.wikimedia.org/wikipedia/commons/7/7e/Comparison_computational_complexity.svg)

The graph demonstrates how different time complexities grow with increasing input size, highlighting why efficient algorithms are critical for large datasets.

## Best Practices

1. **Choose appropriate data structures**: Different data structures have different time complexities for various operations
2. **Optimize inner loops**: Focus on optimizing the most frequently executed parts of code
3. **Use efficient algorithms**: Select algorithms with better time complexity whenever possible
4. **Trade space for time**: Sometimes using more memory can improve runtime complexity
5. **Avoid premature optimization**: Profile your code before optimizing

## Resources

- [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition) by Cormen, Leiserson, Rivest, and Stein
- [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
- [Khan Academy: Algorithms](https://www.khanacademy.org/computing/computer-science/algorithms)
- [Visualizing Algorithms](https://visualgo.net/)
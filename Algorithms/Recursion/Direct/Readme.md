# Direct Recursion

## Introduction
Direct recursion occurs when a function calls itself directly within its own definition. It is a fundamental concept in computer science and a powerful technique for solving problems that can be broken down into smaller, similar subproblems.

## Definition
In direct recursion, a method or function invokes itself to solve a smaller instance of the same problem. Every recursive solution must have:
- A base case (terminating condition)
- A recursive case (where the function calls itself)

## Examples

### Factorial Calculation
```java
int factorial(int n) {
    // Base case
    if (n == 0 || n == 1) {
        return 1;
    }
    // Recursive case
    return n * factorial(n - 1);
}
```

### Fibonacci Sequence
```java
int fibonacci(int n) {
    // Base case
    if (n <= 1) {
        return n;
    }
    // Recursive case
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

### Sum of Array Elements
```java
int sum(int[] arr, int index) {
    // Base case
    if (index >= arr.length) {
        return 0;
    }
    // Recursive case
    return arr[index] + sum(arr, index + 1);
}
```

## Advantages and Disadvantages

### Advantages
- Elegant and concise solutions for certain problems
- Easier to understand and implement for naturally recursive problems
- Reduces complex problems to simpler ones

### Disadvantages
- Risk of stack overflow for deep recursion
- Performance overhead due to multiple function calls
- May use more memory than iterative solutions

## Best Practices
1. Always define a proper base case
2. Ensure progress toward the base case in each recursive call
3. Consider stack depth limitations
4. Use tail recursion when possible for optimization
5. Consider iterative solutions for performance-critical applications

## Applications
- Tree and graph traversals
- Divide and conquer algorithms
- Dynamic programming
- Backtracking algorithms
- Parsing and syntax analysis
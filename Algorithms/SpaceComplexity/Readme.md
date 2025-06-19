# Space Complexity

## Introduction
Space complexity is a measure of how much memory an algorithm or program needs to run as a function of the input size. Just as time complexity analyzes execution time, space complexity analyzes memory usage.

## Table of Contents
- [Understanding Space Complexity](#understanding-space-complexity)
- [Types of Space Complexity](#types-of-space-complexity)
- [Analyzing Space Complexity](#analyzing-space-complexity)
- [Common Space Complexities](#common-space-complexities)
- [Examples with Code](#examples-with-code)
- [Space-Time Tradeoffs](#space-time-tradeoffs)
- [Best Practices](#best-practices)

## Understanding Space Complexity

Space complexity includes:
- **Input space**: Memory needed to store the input data
- **Auxiliary space**: Extra space used by the algorithm (excluding input)
- **Total space**: Input space + Auxiliary space

Space complexity is typically expressed using Big O notation, focusing on how memory requirements grow relative to input size.

## Types of Space Complexity

1. **Constant Space O(1)**: Memory usage doesn't increase with input size
2. **Linear Space O(n)**: Memory usage grows linearly with input size
3. **Quadratic Space O(n²)**: Memory usage grows quadratically with input size
4. **Logarithmic Space O(log n)**: Memory usage grows logarithmically
5. **Exponential Space O(2ⁿ)**: Memory usage doubles with each increase in input size

## Analyzing Space Complexity

To analyze space complexity:
1. Identify variables and data structures used
2. Determine how their size scales with input
3. Consider recursive call stack space
4. Sum all space requirements
5. Express using Big O notation, keeping only the highest-order term

## Common Space Complexities

| Complexity | Description | Examples |
|------------|-------------|----------|
| O(1) | Uses fixed space | Simple variables, fixed-size arrays |
| O(log n) | Space grows logarithmically | Binary search, some divide and conquer algorithms |
| O(n) | Space grows linearly | Linear search, copying arrays |
| O(n²) | Space grows quadratically | 2D arrays, adjacency matrices |
| O(2ⁿ) | Space grows exponentially | Naive recursive solutions for Fibonacci, subset generation |

## Examples with Code

### Constant Space O(1)
### Constant Space O(1)
```java
public static int findMax(int[] arr) {
    int maxVal = Integer.MIN_VALUE;
    for (int num : arr) {
        if (num > maxVal) {
            maxVal = num;
        }
    }
    return maxVal;
}
```

### Linear Space O(n)
```java
public static int[] duplicateArray(int[] arr) {
    int[] duplicate = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        duplicate[i] = arr[i];
    }
    return duplicate;
}
```

### Quadratic Space O(n²)
```java
public static int[][] createMatrix(int n) {
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = i * j;
        }
    }
    return matrix;
}
```

## Space-Time Tradeoffs

Often, algorithms can be optimized for space at the expense of time, or vice versa:

- **Memoization**: Trades space for time by storing computed results
- **Recursion vs. Iteration**: Recursive solutions often use more space (call stack) but can be more readable
- **In-place algorithms**: Minimize space by modifying input directly, sometimes at the cost of clarity or time

## Best Practices

1. Consider both space and time complexity when designing algorithms
2. For large inputs, prioritize algorithms with efficient space complexity
3. Use in-place operations when appropriate
4. Be aware of hidden space costs (call stack, temporary objects)
5. Profile real memory usage for critical applications

Remember that the best algorithm depends on specific requirements, constraints, and the nature of the data being processed.

## Additional Resources

- [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition) by Cormen et al.
- [Algorithm Design Manual](http://www.algorist.com/) by Skiena
- [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
# Tail Recursion

## Introduction
Tail recursion is a special form of recursion where the recursive call is the last operation performed in the function. This means that after the recursive call, there are no pending operations that need to be completed.

## Table of Contents
- [What is Tail Recursion?](#what-is-tail-recursion)
- [Tail vs. Non-Tail Recursion](#tail-vs-non-tail-recursion)
- [Advantages of Tail Recursion](#advantages-of-tail-recursion)
- [Tail Call Optimization (TCO)](#tail-call-optimization-tco)
- [Examples](#examples)
- [Best Practices](#best-practices)
- [Languages with TCO Support](#languages-with-tco-support)
- [Further Reading](#further-reading)

## What is Tail Recursion?
In tail recursion, the recursive call is the final action in the function. The function doesn't perform any additional operations after the recursive call returns. This property allows compilers to optimize the recursion into an iterative loop, avoiding stack overflow for deep recursions.

## Tail vs. Non-Tail Recursion
### Non-Tail Recursive (Standard Recursion)
```java
// Non-tail recursive factorial
int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1); // Result needs to be processed after the recursive call returns
}
```

### Tail Recursive
```java
// Tail recursive factorial
// Tail recursive factorial
int factorialTail(int n, int accumulator) {
    if (n <= 1) return accumulator;
    return factorialTail(n - 1, n * accumulator); // No pending operations after the recursive call
}

// Helper method to provide default value
int factorialTail(int n) {
    return factorialTail(n, 1);
}
```

## Advantages of Tail Recursion
1. **Memory Efficiency**: Optimized tail recursion doesn't grow the call stack
2. **Prevention of Stack Overflow**: Allows for deeper recursion without stack limitations
3. **Performance Improvement**: Can be as efficient as iterative solutions
4. **Cleaner Code**: Often provides more elegant solutions than iteration for certain problems

## Tail Call Optimization (TCO)
Tail Call Optimization is a compiler technique that transforms tail recursive calls into iterations. Instead of adding a new stack frame for each recursive call, the compiler reuses the existing stack frame.

### How TCO Works
1. Identify that the function ends with a tail call
2. Replace the current stack frame with the new one instead of nesting them
3. Jump back to the beginning of the function with new parameter values

## Examples


### Fibonacci Sequence
```java
// Non-tail recursive (inefficient)
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);
}

// Tail recursive
int fibonacciTail(int n, int a, int b) {
    if (n == 0) return a;
    if (n == 1) return b;
    return fibonacciTail(n-1, b, a+b);
}

// Helper method with default values
int fibonacciTail(int n) {
    return fibonacciTail(n, 0, 1);
}
```

### Sum of Array Elements
```java
// Non-tail recursive
int sumArray(int[] arr, int index) {
    if (index >= arr.length) return 0;
    return arr[index] + sumArray(arr, index + 1);
}

// Helper method
int sumArray(int[] arr) {
    return sumArray(arr, 0);
}

// Tail recursive
int sumArrayTail(int[] arr, int index, int acc) {
    if (index >= arr.length) return acc;
    return sumArrayTail(arr, index + 1, acc + arr[index]);
}

// Helper method with default values
int sumArrayTail(int[] arr) {
    return sumArrayTail(arr, 0, 0);
}
```

## Best Practices
1. Use an accumulator parameter to store intermediate results
2. Ensure the recursive call is truly the last operation
3. Understand your language's support for tail call optimization
4. Consider iteration as an alternative when recursion depth is a concern
5. Test with large inputs to verify stack overflow prevention

## Languages with TCO Support
- **Full Support**: Scheme, Scala, Elixir, Haskell, Erlang
- **Partial Support**: JavaScript (in strict mode, but implementation varies)
- **Limited/No Support**: Python, Java, C++, Ruby

## Further Reading
- [Tail Call Optimization in ECMAScript 6](https://2ality.com/2015/06/tail-call-optimization.html)
- [Understanding Recursion in Functional Programming](https://www.cs.cornell.edu/courses/cs3110/2019sp/textbook/data/tail_recursion.html)
- [Wikipedia: Tail Call](https://en.wikipedia.org/wiki/Tail_call)

---

*Note: Always check your specific language implementation and compiler options to ensure tail call optimization is supported and enabled.*
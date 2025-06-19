# Indirect Recursion

## Overview
Indirect recursion (also known as mutual recursion) occurs when a function A calls another function B, which in turn calls function A again, either directly or through a chain of other function calls. This creates a cycle of function calls where multiple functions are involved in the recursive process.

Unlike direct recursion where a function calls itself, indirect recursion involves two or more functions calling each other in a circular manner.

## Key Characteristics
- Involves multiple functions that call each other
- Creates a cycle of function calls
- Requires proper base cases to prevent infinite recursion
- Common in certain algorithms and language processing applications

## Example Explained

The following Java code demonstrates indirect recursion through two mutually recursive functions:

```java
public class code {
    // Example of indirect recursion with even and odd number checks
    public static boolean isEven(int n) {
        if (n == 0) {
            return true;
        }
        // Even numbers are those whose predecessors are odd
        return isOdd(n - 1);
    }

    public static boolean isOdd(int n) {
        if (n == 0) {
            return false;
        }
        // Odd numbers are those whose predecessors are even
        return isEven(n - 1);
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println(num + " is even: " + isEven(num));
        
        num = 15;
        System.out.println(num + " is even: " + isEven(num));
        System.out.println(num + " is odd: " + isOdd(num));
    }
}
```

### How This Example Works

The code determines if a number is even or odd using indirect recursion:

1. **Base Cases**:
   - In `isEven()`: If n is 0, return true (0 is even)
   - In `isOdd()`: If n is 0, return false (0 is not odd)

2. **Recursive Cases**:
   - A number is even if its predecessor is odd
   - A number is odd if its predecessor is even

3. **Execution Flow Example** for `isEven(3)`:
   - `isEven(3)` calls `isOdd(2)`
   - `isOdd(2)` calls `isEven(1)`
   - `isEven(1)` calls `isOdd(0)`
   - `isOdd(0)` returns false (base case)
   - `isEven(1)` returns false
   - `isOdd(2)` returns false
   - `isEven(3)` returns false (3 is not even)

4. **Program Output**:
   ```
   10 is even: true
   15 is even: false
   15 is odd: true
   ```

## Advantages & Challenges

**Advantages:**
- Provides elegant solutions for problems that naturally have mutual dependencies
- Often results in more readable and maintainable code for certain algorithms

**Challenges:**
- Can be harder to trace and debug
- Must carefully design base cases to prevent infinite recursion
- May cause stack overflow with deep recursion chains

## Applications
Indirect recursion is commonly used in:
- Parsing expressions or language constructs
- Tree traversal algorithms
- Mathematical functions with mutual dependency
- State machine implementations
package Algorithms.Recursion.Direct;

public class code {
    // Direct recursion examples
    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Fibonacci number at position 7: " + fibonacci(7));
        System.out.println("Sum of first 10 natural numbers: " + sumNaturalNumbers(10));
        
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int index = binarySearch(sortedArray, 0, sortedArray.length - 1, target);
        System.out.println("Index of " + target + " in array: " + index);
    }

    // Example 1: Factorial calculation using direct recursion
    public static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case - method calls itself directly
        return n * factorial(n - 1);
    }

    // Example 2: Fibonacci sequence using direct recursion
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        // Recursive case - method calls itself directly
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Example 3: Sum of first n natural numbers using direct recursion
    public static int sumNaturalNumbers(int n) {
        // Base case
        if (n == 1) {
            return 1;
        }
        // Recursive case - method calls itself directly
        return n + sumNaturalNumbers(n - 1);
    }

    // Example 4: Binary search using direct recursion
    public static int binarySearch(int[] array, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (array[mid] == target) {
            return mid;
        }
        
        if (array[mid] > target) {
            return binarySearch(array, left, mid - 1, target);
        } else {
            return binarySearch(array, mid + 1, right, target);
        }
    }
}

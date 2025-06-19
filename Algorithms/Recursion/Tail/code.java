package Algorithms.Recursion.Tail;

public class code {
    
    // Tail recursion example
    public int factorial(int n) {
        return factorialHelper(n, 1);
    }

    private int factorialHelper(int n, int accumulator) {
        if (n == 0) {
            return accumulator;
        }
        return factorialHelper(n - 1, n * accumulator);
    }

    public static void main(String[] args) {
        code example = new code();
        System.out.println("Factorial of 5: " + example.factorial(5)); // Output: 120
    }
}

package Algorithms.Recursion.Indirect;

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

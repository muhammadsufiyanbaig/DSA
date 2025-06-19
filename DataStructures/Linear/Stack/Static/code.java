package DataStructures.Linear.Stack.Static;
class StaticStack {
    int maxSize = 5;
    int[] stack = new int[maxSize];
    int top = -1;

    void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
        }
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    int peek() {
        if (top == -1) return -1;
        return stack[top];
    }
}

public class code {
    public static void main(String[] args) {
        StaticStack stack = new StaticStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // This will cause Stack Overflow

        System.out.println("Top element is: " + stack.peek()); // Output: 50

        System.out.println("Popped element: " + stack.pop()); // Output: 50
        System.out.println("Popped element: " + stack.pop()); // Output: 40
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 20
        System.out.println("Popped element: " + stack.pop()); // Output: 10
        System.out.println("Popped element: " + stack.pop()); // Output: Stack Underflow, -1
    }
}

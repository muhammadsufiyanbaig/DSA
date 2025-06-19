package DataStructures.Linear.Stack.Dynamic;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

class DynamicStack {
    Node top = null;

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    int peek() {
        return (top != null) ? top.data : -1;
    }
}

public class code {
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek()); // Output: 30

        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 20
        System.out.println("Popped element: " + stack.pop()); // Output: 10
        System.out.println("Popped element: " + stack.pop()); // Output: Stack Underflow, -1
    }
}

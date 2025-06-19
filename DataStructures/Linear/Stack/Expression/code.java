package DataStructures.Linear.Stack.Expression;
import java.util.Stack;

class ExpressionStack {
    // Evaluates postfix expression
    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        
        for (char c : expr.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');  // Convert char to int
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
    
    // Evaluates prefix expression
    public static int evaluatePrefix(String expr) {
        Stack<Integer> stack = new Stack<>();
        
        // Process from right to left for prefix
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
    
    // Convert infix to postfix
    public static String infixToPostfix(String expr) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char c : expr.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove the '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
    
    // Convert infix to prefix
    public static String infixToPrefix(String expr) {
        // Reverse the string, swap ( and )
        StringBuilder reversed = new StringBuilder();
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c == '(') reversed.append(')');
            else if (c == ')') reversed.append('(');
            else reversed.append(c);
        }
        
        // Convert to postfix
        String postfix = infixToPostfix(reversed.toString());
        
        // Reverse again to get prefix
        return new StringBuilder(postfix).reverse().toString();
    }
    
    // Convert postfix to infix
    public static String postfixToInfix(String expr) {
        Stack<String> stack = new Stack<>();
        
        for (char c : expr.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String b = stack.pop();
                String a = stack.pop();
                stack.push("(" + a + c + b + ")");
            }
        }
        
        return stack.pop();
    }
    
    // Convert prefix to infix
    public static String prefixToInfix(String expr) {
        Stack<String> stack = new Stack<>();
        
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.push("(" + a + c + b + ")");
            }
        }
        
        return stack.pop();
    }
    
    private static int precedence(char operator) {
        switch (operator) {
            case '+': 
            case '-': 
                return 1;
            case '*': 
            case '/': 
                return 2;
            case '^': 
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String postfix = "23*54*+9-";
        int result = evaluatePostfix(postfix);
        System.out.println("Postfix Evaluation: " + result);  // Output: 17
        
        String infix = "(2*3)+(5*4)-9";
        System.out.println("Infix: " + infix);
        System.out.println("Infix to Postfix: " + infixToPostfix(infix));
        System.out.println("Infix to Prefix: " + infixToPrefix(infix));
        
        String prefix = "-+*23*549";
        System.out.println("Prefix Evaluation: " + evaluatePrefix(prefix));
        
        System.out.println("Postfix to Infix: " + postfixToInfix(postfix));
        System.out.println("Prefix to Infix: " + prefixToInfix(prefix));
    }
}
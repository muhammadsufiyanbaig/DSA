package DataStructures.NonLinear.Tree.ExpressionTree;

import java.util.*;

public class ExpressionTree {
    // Node.java
    abstract class Node {
    public abstract double evaluate();
    public abstract String toString();
}

// NumberNode.java
class NumberNode extends Node {
    private double value;
    
    public NumberNode(double value) {
        this.value = value;
    }
    
    @Override
    public double evaluate() {
        return value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

// OperatorNode.java
class OperatorNode extends Node {
    private char operator;
    private Node left;
    private Node right;
    
    public OperatorNode(char operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double evaluate() {
        double leftVal = left.evaluate();
        double rightVal = right.evaluate();
        
        switch (operator) {
            case '+':
                return leftVal + rightVal;
            case '-':
                return leftVal - rightVal;
            case '*':
                return leftVal * rightVal;
            case '/':
                if (rightVal == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return leftVal / rightVal;
            case '^':
                return Math.pow(leftVal, rightVal);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    
    @Override
    public String toString() {
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }
}

    private Node root;
    
    public ExpressionTree(String expression) {
        this.root = buildFromInfix(expression);
    }
    
    public ExpressionTree(Node root) {
        this.root = root;
    }
    
    // Build expression tree from infix expression
    private Node buildFromInfix(String expression) {
        // Convert infix to postfix first
        String postfix = infixToPostfix(expression);
        return buildFromPostfix(postfix);
    }
    
    // Convert infix expression to postfix using Shunting Yard algorithm
    private String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            if (Character.isWhitespace(c)) {
                continue;
            }
            
            if (Character.isDigit(c) || c == '.') {
                // Handle multi-digit numbers and decimals
                StringBuilder num = new StringBuilder();
                while (i < infix.length() && 
                       (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    num.append(infix.charAt(i));
                    i++;
                }
                i--; // Adjust for the extra increment in the loop
                result.append(num).append(" ");
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the '('
                }
            }
            else if (isOperator(c)) {
                while (!stack.isEmpty() && 
                       stack.peek() != '(' && 
                       precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        
        return result.toString().trim();
    }
    
    // Build expression tree from postfix expression
    private Node buildFromPostfix(String postfix) {
        Stack<Node> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");
        
        for (String token : tokens) {
            if (token.isEmpty()) continue;
            
            if (isOperator(token.charAt(0)) && token.length() == 1) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                Node right = stack.pop();
                Node left = stack.pop();
                stack.push(new OperatorNode(token.charAt(0), left, right));
            } else {
                try {
                    double value = Double.parseDouble(token);
                    stack.push(new NumberNode(value));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid token: " + token);
                }
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        
        return stack.pop();
    }
    
    // Helper method to check if character is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    
    // Get operator precedence
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    
    // Evaluate the expression tree
    public double evaluate() {
        if (root == null) {
            throw new IllegalStateException("Expression tree is empty");
        }
        return root.evaluate();
    }
    
    // Get infix representation of the expression
    public String getInfixExpression() {
        if (root == null) {
            throw new IllegalStateException("Expression tree is empty");
        }
        return root.toString();
    }
    
    // Get prefix representation (preorder traversal)
    public String getPrefixExpression() {
        if (root == null) {
            throw new IllegalStateException("Expression tree is empty");
        }
        return getPrefixHelper(root);
    }
    
    private String getPrefixHelper(Node node) {
        if (node instanceof NumberNode) {
            return node.toString();
        } else if (node instanceof OperatorNode) {
            OperatorNode opNode = (OperatorNode) node;
            return opNode.toString().charAt(opNode.toString().indexOf(' ') + 1) + " " +
                   getPrefixHelper(((OperatorNode) node).left) + " " +
                   getPrefixHelper(((OperatorNode) node).right);
        }
        return "";
    }
    
    // Get postfix representation (postorder traversal)
    public String getPostfixExpression() {
        if (root == null) {
            throw new IllegalStateException("Expression tree is empty");
        }
        return getPostfixHelper(root);
    }
    
    private String getPostfixHelper(Node node) {
        if (node instanceof NumberNode) {
            return node.toString();
        } else if (node instanceof OperatorNode) {
            OperatorNode opNode = (OperatorNode) node;
            return getPostfixHelper(((OperatorNode) node).left) + " " +
                   getPostfixHelper(((OperatorNode) node).right) + " " +
                   opNode.toString().charAt(opNode.toString().indexOf(' ') + 1);
        }
        return "";
    }
    
    // Print tree structure
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        printTreeHelper(root, "", true);
    }
    
    private void printTreeHelper(Node node, String prefix, boolean isLast) {
        if (node != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + node.toString());
            
            if (node instanceof OperatorNode) {
                OperatorNode opNode = (OperatorNode) node;
                // Get left and right children using reflection or add getters
                printTreeHelper(getLeftChild(opNode), prefix + (isLast ? "    " : "│   "), false);
                printTreeHelper(getRightChild(opNode), prefix + (isLast ? "    " : "│   "), true);
            }
        }
    }
    
    // Helper methods to access private fields (in real implementation, add getters)
    private Node getLeftChild(OperatorNode node) {
        try {
            java.lang.reflect.Field leftField = OperatorNode.class.getDeclaredField("left");
            leftField.setAccessible(true);
            return (Node) leftField.get(node);
        } catch (Exception e) {
            return null;
        }
    }
    
    private Node getRightChild(OperatorNode node) {
        try {
            java.lang.reflect.Field rightField = OperatorNode.class.getDeclaredField("right");
            rightField.setAccessible(true);
            return (Node) rightField.get(node);
        } catch (Exception e) {
            return null;
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        try {
            // Test various expressions
            String[] expressions = {
                "3 + 4 * 2",
                "(3 + 4) * 2",
                "10 - 5 + 2",
                "8 / 2 / 2",
                "2 ^ 3 ^ 2",
                "3.5 + 2.1 * 4"
            };
            
            for (String expr : expressions) {
                System.out.println("Expression: " + expr);
                ExpressionTree tree = new ExpressionTree(expr);
                
                System.out.println("Infix: " + tree.getInfixExpression());
                System.out.println("Prefix: " + tree.getPrefixExpression());
                System.out.println("Postfix: " + tree.getPostfixExpression());
                System.out.println("Result: " + tree.evaluate());
                System.out.println("Tree structure:");
                tree.printTree();
                System.out.println("----------------------------------------");
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

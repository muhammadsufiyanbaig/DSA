# Expression Tree Implementation in Java

A comprehensive implementation of an expression tree data structure that can parse, evaluate, and represent mathematical expressions in various notations.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Class Structure](#class-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Supported Operations](#supported-operations)
- [Algorithm Details](#algorithm-details)
- [Error Handling](#error-handling)
- [Contributing](#contributing)
- [License](#license)

## Overview

An expression tree is a binary tree where:
- **Leaf nodes** represent operands (numbers)
- **Internal nodes** represent operators (+, -, *, /, ^)
- The tree structure respects operator precedence and associativity

This implementation converts infix expressions to expression trees and provides multiple ways to evaluate and represent the expressions.

## Features

- ✅ **Infix to Expression Tree Conversion**: Parse standard mathematical expressions
- ✅ **Multiple Notation Support**: Generate infix, prefix, and postfix representations
- ✅ **Expression Evaluation**: Calculate the result of mathematical expressions
- ✅ **Tree Visualization**: Display the tree structure in a readable format
- ✅ **Operator Precedence**: Correctly handles operator precedence and associativity
- ✅ **Decimal Number Support**: Handles both integers and floating-point numbers
- ✅ **Error Handling**: Comprehensive error checking for invalid expressions
- ✅ **Extensible Design**: Easy to add new operators and functions

## Class Structure

### Core Classes

1. **`Node`** (Abstract Base Class)
   - Base class for all tree nodes
   - Defines `evaluate()` and `toString()` methods

2. **`NumberNode`** (Leaf Node)
   - Represents numeric values
   - Stores double precision numbers

3. **`OperatorNode`** (Internal Node)
   - Represents mathematical operators
   - Contains references to left and right child nodes

4. **`ExpressionTree`** (Main Class)
   - Manages the entire expression tree
   - Provides parsing, evaluation, and conversion methods

### Class Hierarchy
```
Node (Abstract)
├── NumberNode
└── OperatorNode
```

## Installation

1. **Clone or Download** the source files
2. **Compile** the Java files:
   ```bash
   javac *.java
   ```
3. **Run** the main class:
   ```bash
   java ExpressionTree
   ```

## Usage

### Basic Usage

```java
// Create an expression tree from an infix expression
ExpressionTree tree = new ExpressionTree("3 + 4 * 2");

// Evaluate the expression
double result = tree.evaluate(); // Returns 11.0

// Get different representations
String infix = tree.getInfixExpression();     // "(3.0 + (4.0 * 2.0))"
String prefix = tree.getPrefixExpression();   // "+ 3.0 * 4.0 2.0"
String postfix = tree.getPostfixExpression(); // "3.0 4.0 2.0 * +"

// Visualize the tree structure
tree.printTree();
```

### Advanced Usage

```java
// Handle complex expressions with parentheses
ExpressionTree complexTree = new ExpressionTree("(3 + 4) * (5 - 2)");
System.out.println("Result: " + complexTree.evaluate()); // Result: 21.0

// Work with decimal numbers
ExpressionTree decimalTree = new ExpressionTree("3.14 * 2.0 + 1.5");
System.out.println("Result: " + decimalTree.evaluate()); // Result: 7.78

// Handle exponentiation
ExpressionTree powerTree = new ExpressionTree("2 ^ 3 ^ 2");
System.out.println("Result: " + powerTree.evaluate()); // Result: 512.0
```

## Examples

### Example 1: Simple Arithmetic
```java
ExpressionTree tree = new ExpressionTree("5 + 3 * 2");
System.out.println("Expression: 5 + 3 * 2");
System.out.println("Result: " + tree.evaluate());        // 11.0
System.out.println("Infix: " + tree.getInfixExpression()); // (5.0 + (3.0 * 2.0))
```

### Example 2: Parentheses
```java
ExpressionTree tree = new ExpressionTree("(5 + 3) * 2");
System.out.println("Expression: (5 + 3) * 2");
System.out.println("Result: " + tree.evaluate());        // 16.0
System.out.println("Prefix: " + tree.getPrefixExpression()); // * + 5.0 3.0 2.0
```

### Example 3: Complex Expression
```java
ExpressionTree tree = new ExpressionTree("2 ^ 3 + 4 * 5 - 6 / 2");
System.out.println("Expression: 2 ^ 3 + 4 * 5 - 6 / 2");
System.out.println("Result: " + tree.evaluate());        // 25.0
tree.printTree(); // Displays tree structure
```

## Supported Operations

| Operator | Description | Precedence | Associativity |
|----------|-------------|------------|---------------|
| `+` | Addition | 1 | Left |
| `-` | Subtraction | 1 | Left |
| `*` | Multiplication | 2 | Left |
| `/` | Division | 2 | Left |
| `^` | Exponentiation | 3 | Right |

### Precedence Rules
- Higher precedence operators are evaluated first
- Same precedence operators are evaluated left-to-right (except exponentiation)
- Parentheses override precedence rules

## Algorithm Details

### Infix to Postfix Conversion (Shunting Yard Algorithm)
1. **Scan** the infix expression from left to right
2. **Numbers**: Add directly to output
3. **Operators**: 
   - Pop operators with higher/equal precedence from stack to output
   - Push current operator to stack
4. **Left Parenthesis**: Push to stack
5. **Right Parenthesis**: Pop operators until left parenthesis is found
6. **End**: Pop all remaining operators from stack

### Tree Construction from Postfix
1. **Scan** postfix expression from left to right
2. **Numbers**: Create NumberNode and push to stack
3. **Operators**: 
   - Pop two nodes from stack (right, then left)
   - Create OperatorNode with these children
   - Push new node to stack
4. **Result**: Final node on stack is the tree root

### Time Complexity
- **Parsing**: O(n) where n is the length of the expression
- **Evaluation**: O(n) where n is the number of nodes in the tree
- **Tree Construction**: O(n)

### Space Complexity
- **Tree Storage**: O(n) for storing all nodes
- **Stack Usage**: O(h) where h is the height of the tree

## Error Handling

The implementation includes comprehensive error handling for:

### Common Errors
- **Division by Zero**: Throws `ArithmeticException`
- **Invalid Expressions**: Throws `IllegalArgumentException`
- **Malformed Numbers**: Throws `NumberFormatException`
- **Unbalanced Parentheses**: Detected during parsing
- **Unknown Operators**: Throws `IllegalArgumentException`

### Example Error Handling
```java
try {
    ExpressionTree tree = new ExpressionTree("5 / 0");
    double result = tree.evaluate(); // Throws ArithmeticException
} catch (ArithmeticException e) {
    System.err.println("Error: " + e.getMessage());
}
```

## Extension Points

### Adding New Operators
To add a new operator (e.g., modulus `%`):

1. **Update `isOperator()` method**:
   ```java
   private boolean isOperator(char c) {
       return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%';
   }
   ```

2. **Add precedence in `precedence()` method**:
   ```java
   case '%':
       return 2; // Same as multiplication/division
   ```

3. **Handle evaluation in `OperatorNode.evaluate()`**:
   ```java
   case '%':
       return leftVal % rightVal;
   ```

### Adding Variables
To support variables (e.g., `x`, `y`):
1. Create a `VariableNode` class extending `Node`
2. Maintain a symbol table for variable values
3. Update the parser to recognize variable names

## Testing

The main method includes comprehensive tests for:
- Basic arithmetic operations
- Operator precedence
- Parentheses handling
- Decimal numbers
- Complex expressions
- Error conditions

Run tests with:
```bash
java ExpressionTree
```

## Performance Considerations

- **Memory Usage**: Each node requires object overhead (~24 bytes on 64-bit JVM)
- **Parsing Time**: Linear with expression length
- **Evaluation Time**: Single tree traversal
- **Stack Depth**: Limited by Java's call stack during recursive operations

## Best Practices

1. **Input Validation**: Always validate expressions before parsing
2. **Error Handling**: Use try-catch blocks for evaluation
3. **Memory Management**: Trees are automatically garbage collected
4. **Thread Safety**: Create separate instances for concurrent access

## Common Use Cases

- **Calculator Applications**: GUI or command-line calculators
- **Mathematical Expression Parsers**: Parsing user input in applications
- **Compiler Design**: Expression parsing in interpreters/compilers
- **Educational Tools**: Teaching data structures and algorithms
- **Formula Evaluation**: Spreadsheet-like applications

## Limitations

- **Single-character Operators**: Currently supports only single-character operators
- **No Functions**: Doesn't support mathematical functions (sin, cos, etc.)
- **No Variables**: Doesn't support variable substitution
- **Integer Division**: Uses floating-point division only

## Future Enhancements

- [ ] Support for mathematical functions (sin, cos, log, etc.)
- [ ] Variable support with symbol tables
- [ ] Multi-character operators (>=, <=, ==)
- [ ] Boolean expressions and logical operators
- [ ] Optimization for constant expressions
- [ ] Serialization support for saving/loading trees

## Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Add tests for new functionality
4. Ensure all tests pass
5. Submit a pull request


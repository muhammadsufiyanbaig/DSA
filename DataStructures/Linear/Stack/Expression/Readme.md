# Expression Stack Implementation

This repository contains implementations for working with mathematical expressions using stack data structures. It covers the three common expression notations: infix, prefix, and postfix.

## Expression Notations

### Infix Notation
- The conventional notation where operators appear between operands (e.g., `A + B`)
- Natural for humans to read but requires precedence rules and parentheses
- Example: `(A + B) * (C - D)`

### Prefix (Polish) Notation
- Operators appear before their operands (e.g., `+ A B`)
- Eliminates the need for precedence rules and parentheses
- Example: `* + A B - C D`

### Postfix (Reverse Polish) Notation
- Operators appear after their operands (e.g., `A B +`)
- Eliminates the need for precedence rules and parentheses
- Example: `A B + C D - *`

## Conversion Algorithms

This repository implements the following conversions:
- Infix to Postfix
- Infix to Prefix
- Postfix to Infix
- Prefix to Infix

## Expression Evaluation

Stack-based algorithms for evaluating:
- Postfix expressions
- Prefix expressions

## Implementation Details

The stack data structure is fundamental to expression parsing and evaluation. This implementation:

- Uses stack operations for efficient expression conversion
- Handles operator precedence and associativity
- Provides proper parenthesis matching
- Supports common arithmetic operators (+, -, *, /, ^)


## Time Complexity

- Infix to Postfix/Prefix conversion: O(n)
- Expression evaluation: O(n)

Where n is the number of symbols in the expression.

## References

- Data Structures and Algorithms
- Compiler Design principles
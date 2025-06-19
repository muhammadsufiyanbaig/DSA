# Tower of Hanoi

## Introduction
The Tower of Hanoi is a classic mathematical puzzle that consists of three rods and a number of disks of different sizes. The puzzle starts with all disks stacked on one rod in order of decreasing size, with the largest at the bottom.

## Problem Statement
The objective of the puzzle is to move the entire stack of disks from the source rod to a destination rod, following these rules:
1. Only one disk can be moved at a time.
2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.
3. No disk may be placed on top of a smaller disk.

## Algorithm
The Tower of Hanoi can be solved using a recursive algorithm:
1. Move n-1 disks from the source to the auxiliary rod.
2. Move the largest disk from the source to the destination rod.
3. Move the n-1 disks from the auxiliary rod to the destination rod.

## Implementation

```python
def tower_of_hanoi(n, source, destination, auxiliary):
    if n == 1:
        print(f"Move disk 1 from rod {source} to rod {destination}")
        return
    tower_of_hanoi(n-1, source, auxiliary, destination)
    print(f"Move disk {n} from rod {source} to rod {destination}")
    tower_of_hanoi(n-1, auxiliary, destination, source)

# Example usage
n = 3
tower_of_hanoi(n, 'A', 'C', 'B')
```

## Complexity Analysis
- Time Complexity: O(2^n)
- Space Complexity: O(n) due to the recursive stack

## Mathematical Formula
The minimum number of moves required to solve a Tower of Hanoi puzzle is 2^n - 1, where n is the number of disks.

## Applications
- Teaching recursion in computer science
- Understanding exponential algorithms
- Used as a backup rotation scheme in computer science

## Fun Fact
There is a legend that says that monks in a temple are attempting to move a stack of 64 golden disks according to the rules of the Tower of Hanoi. When they finish, the world will end. If they move one disk per second, it will take them 2^64 - 1 seconds, which is about 585 billion years!
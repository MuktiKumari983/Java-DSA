# Two Pointers

##  Overview

The **Two Pointers** technique is an efficient algorithmic pattern used to solve array and string problems by maintaining two indices that move through the data structure.

Instead of using nested loops (O(n²)), many problems can be solved in **O(n)** time by intelligently moving the pointers.

---

## Learning Objectives

- Understand when to use two pointers
- Optimize brute-force solutions
- Solve problems in linear time
- Learn different pointer movement strategies
- Improve interview problem-solving skills

---

##  Common Patterns

### 1. Opposite Direction Pointers
- One pointer starts from the beginning.
- One pointer starts from the end.

Example:
- Two Sum II
- Valid Palindrome
- Container With Most Water

---

### 2. Same Direction Pointers
- Both pointers move from left to right.
- One pointer usually explores while the other maintains a condition.

Example:
- Remove Duplicates from Sorted Array
- Move Zeroes
- Remove Element

---

### 3. Fast & Slow Pointers
- Fast pointer moves faster than slow pointer.

Example:
- Linked List Cycle
- Middle of Linked List
- Happy Number

---

### 4. Merge Two Arrays
- Compare elements from two sorted arrays.

Example:
- Merge Sorted Array
- Intersection of Two Arrays

---

##  Time Complexity

| Approach | Time |
|----------|------|
| Brute Force | O(n²) |
| Two Pointers | O(n) |

---



##  Key Takeaways

- Two pointers help eliminate unnecessary comparisons.
- Works best on **sorted arrays**, **strings**, and **linked lists**.
- Often reduces **O(n²)** solutions to **O(n)**.
- Always think about how moving one pointer affects the answer.

---

##  Resources

- LeetCode Two Pointers

---

 This repository is part of my **Java DSA Journey** where I solve problems topic-wise while preparing for **Software Development Engineer (SDE)** interviews.

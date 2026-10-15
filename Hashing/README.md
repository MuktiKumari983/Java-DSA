# Hashing

## Overview

**Hashing** is an efficient algorithmic technique used to store and retrieve data quickly using data structures such as **HashMap** and **HashSet**.

Instead of repeatedly searching through an array or string, hashing allows us to store information and perform fast lookups, often reducing **O(n²)** solutions to **O(n)**.

---

## Learning Objectives

- Understand when to use HashMap and HashSet
- Learn frequency counting techniques
- Detect duplicates efficiently
- Store and retrieve values using keys
- Solve pair and complement problems
- Combine hashing with Prefix Sum and other patterns
- Improve problem-solving skills for SDE interviews

---

## Common Patterns

### 1. Frequency Counting

- Store the frequency of each element.
- Useful for counting numbers or characters.

Example

- Valid Anagram
- Top K Frequent Elements
- Majority Element

```java
HashMap<Integer, Integer> map = new HashMap<>();

for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}

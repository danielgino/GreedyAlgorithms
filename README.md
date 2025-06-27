# Coin Change Problem – Greedy vs. Dynamic Programming

## Problem Statement

Given a set of coin denominations `{1, 6, 10}`, the goal is to make change for a target value (e.g., `12`) using the **minimum number of coins**.

This classic problem demonstrates that **greedy algorithms are not always optimal** for coin change when the denominations are not canonical (i.e., not every greedy choice leads to the global optimum).

---

##  Greedy Algorithm Approach

The greedy strategy picks the **largest possible coin** at each step.

### Example:
- Target: `12`
- Coins: `{1, 6, 10}`

Greedy choice:
- Pick 10 → remainder: 2
- Pick 1 → remainder: 1
- Pick 1 → done

Total coins used: `3` → `{10, 1, 1}`

 Not optimal.

---

## Optimal Solution – Dynamic Programming

Dynamic programming considers **all combinations** of coins and finds the minimum number needed.

### Same example:
- Target: `12`
- Best combination: `6 + 6`

Total coins used: `2` → `{6, 6}`

Optimal solution.

---

##  Code Overview

### `greedyCoins(coins, target)`
- Sorts coins in descending order.
- Always picks the biggest coin that doesn't exceed the remaining amount.

### `dynamicPlanning(coins, target)`
- Uses a `dp[]` array where `dp[i]` holds the minimum coins needed for amount `i`.
- Builds the solution using bottom-up dynamic programming.

---

## 📌 Conclusion

This example clearly shows that greedy algorithms may **fail to find the optimal solution** in the coin change problem.

Dynamic programming is the **reliable approach** when coin denominations are not guaranteed to be canonical.

---
## Example Input

```
int[] coins = {1, 6, 10};
int sumTarget = 12;
```
## 🛠 Example Output

```
Greedy solution: 
10,1,1,
The Sum Of Coins: 12
========================
Dynamic Planning: 
6,6,
The Sum Of Coins: 12

```
# Question 2


#  Line Breaking Problem – Greedy vs. Dynamic Programming

##  Problem Description

Given a sequence of words, the goal is to break them into lines of **maximum length `L`**, while minimizing the **penalty**.

Each line may contain one or more words, separated by single spaces.

---

## Constraints

- Words must remain in their **original order**.
- No line may exceed length `L` (including spaces between words).
- The **length of a line** is the total number of characters (including spaces).
- The **penalty** for a line of length `K` is defined as `L - K`.
- **Every line, including the last**, contributes to the total penalty.

---

##  Greedy Algorithm

The greedy approach adds as many words as possible to the current line.
Once adding a word would exceed `L`, a new line is started.

---

## Dynamic Programming Algorithm

The dynamic approach examines **all possible line breaks**, calculating the minimal penalty using bottom-up dynamic programming.

### Idea:
- Let `dp[i]` represent the minimal penalty to arrange words `i..n-1`.
- Try placing words `i` to `j` on the current line (as long as it fits).
- Compute `penalty = L - lineLength`, and minimize `dp[i] = dp[j+1] + penalty`.

### Complexity:
- Time: `O(n^2)` in the worst case.
- Space: `O(n)`

---

# 📊 Example Run

## Input:
```
String[] words = {"The", "Daniel", "Sharon", "Fox", "Parking", "Game", "Greedy", "Lazy"};
int L = 10;

```

## Output

```
Greedy Solution:
The Daniel | penalty: 0
Sharon Fox | penalty: 0
Parking | penalty: 3
Game | penalty: 6
Greedy | penalty: 4
Lazy | penalty: 6
Total penalty: 19
=========================
Dynamic Programming:
The Daniel | penalty: 0
Sharon Fox | penalty: 0
Parking | penalty: 3
Game | penalty: 6
Greedy | penalty: 4
Lazy | penalty: 6
Total penalty: 19
```


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


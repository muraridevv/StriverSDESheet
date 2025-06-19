package com.murari.striverheet.dynamicprogramming;

import java.util.Arrays;

public class MaxCoinChange {
    // -------------------------- 1. PURE RECURSION --------------------------
    // Very basic and brute-force approach
    public static long recursion(int index, int target, int[] coins) {
        // Base Case: Only one type of coin is allowed
        if (index == 0) {
            // If the target is divisible by that coin, we can make exact change
            return (target % coins[0] == 0) ? 1 : 0;
        }

        // Option 1: Don't pick the current coin
        long notTake = recursion(index - 1, target, coins);

        // Option 2: Pick the current coin (only if it's <= target)
        long take = 0;
        if (coins[index] <= target) {
            // Stay at the same index because coins can be reused
            take = recursion(index, target - coins[index], coins);
        }

        // Total ways = take + notTake
        return take + notTake;
    }

    // -------------------------- 2. MEMOIZATION -----------------------------
    // Top-down DP (recursive + cache)
    public static long memoization(int index, int target, int[] coins, long[][] dp) {
        // Base Case
        if (index == 0) {
            return (target % coins[0] == 0) ? 1 : 0;
        }

        // If already computed, return stored value
        if (dp[index][target] != -1) return dp[index][target];

        // Option 1: Don't take current coin
        long notTake = memoization(index - 1, target, coins, dp);

        // Option 2: Take current coin (if valid)
        long take = 0;
        if (coins[index] <= target) {
            take = memoization(index, target - coins[index], coins, dp);
        }

        // Save result and return
        return dp[index][target] = take + notTake;
    }

    // -------------------------- 3. TABULATION ------------------------------
    // Bottom-up DP (iterative approach)
    public static long tabulation(int[] coins, int n, int T) {
        long[][] dp = new long[n][T + 1];

        // Initialize base case: using only first coin
        for (int i = 0; i <= T; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;  // 1 way to make i using coins[0]
            // else remains 0
        }

        // Fill DP table
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                long notTake = dp[ind - 1][target]; // Exclude current coin
                long take = 0;
                if (coins[ind] <= target) {
                    take = dp[ind][target - coins[ind]]; // Include current coin
                }
                dp[ind][target] = take + notTake;
            }
        }

        // Final answer: ways to make T using all coins
        return dp[n - 1][T];
    }

    // -------------------------- 4. SPACE OPTIMIZATION ----------------------
    // Improves space from O(n*T) to O(T)
    public static long spaceOptimized(int[] coins, int n, int T) {
        long[] prev = new long[T + 1];

        // Base case initialization
        for (int i = 0; i <= T; i++) {
            if (i % coins[0] == 0)
                prev[i] = 1;
        }

        // Build using 1D array
        for (int ind = 1; ind < n; ind++) {
            long[] curr = new long[T + 1];
            for (int target = 0; target <= T; target++) {
                long notTake = prev[target];
                long take = 0;
                if (coins[ind] <= target) {
                    take = curr[target - coins[ind]];
                }
                curr[target] = take + notTake;
            }
            prev = curr; // Move current row to prev for next iteration
        }

        return prev[T];
    }

    // -------------------------- MAIN METHOD --------------------------------
    public static void main(String[] args) {
        int[] coins = {1, 2, 3}; // Coin denominations
        int target = 4;          // Target amount to form
        int n = coins.length;

        // ---------- Uncomment any one approach below to test ----------

        // 1. Pure Recursion (Slow for large inputs)
         System.out.println("Total ways (Recursion): " + recursion(n - 1, target, coins));

        // 2. Memoization (Efficient Top-Down DP)
        long[][] dp = new long[n][target + 1];
        for (long[] row : dp) Arrays.fill(row, -1); // Fill with -1 to mark "not computed"
        System.out.println("Total ways (Memoization): " + memoization(n - 1, target, coins, dp));

        // 3. Tabulation (Efficient Bottom-Up DP)
         System.out.println("Total ways (Tabulation): " + tabulation(coins, n, target));

        // 4. Space Optimization (Most memory-efficient)
         System.out.println("Total ways (Space Optimized): " + spaceOptimized(coins, n, target));
    }
}

package com.murari.striverheet.dynamicprogramming;

public class KnapSack01 {

  public int maxProfitRecursion(int[] weights, int[] values, int capacity, int index) {
    // Base case: if capacity becomes 0 or we have considered all weights
    if (capacity == 0 || index == weights.length) {
      return 0;
    }

    // If the weight of current item exceeds the remaining capacity, exclude it
    if (weights[index] > capacity) {
      return maxProfitRecursion(weights, values, capacity, index + 1);
    }

    // Recursive calls
    // 1. Include the current item in knapsack
    int include =
        values[index] + maxProfitRecursion(weights, values, capacity - weights[index], index + 1);
    // 2. Exclude the current item
    int exclude = maxProfitRecursion(weights, values, capacity, index + 1);

    return Math.max(include, exclude);
  }

  public int maxProfit(int[] weights, int[] values, int capacity, int index) {
    int[][] dp = new int[weights.length + 1][capacity + 1];

    // Fill up the dp using bottom up approach
    for (int i = 1; i <= weights.length; i++) {
      for (int j = 1; j <= capacity; j++) {
        // If the current item's weight is greater than the current capacity, exlude it.
        if (weights[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          // Choose the maximum between the include and excluding the current item
          int exclude = dp[i - 1][j];
          int include = values[i - 1] + dp[i - 1][j - weights[i - 1]];
          dp[i][j] = Math.max(include, exclude);
        }
      }
    }
    return dp[weights.length][capacity];
  }

  public static void main(String[] args) {
    KnapSack01 knapsack = new KnapSack01();
    int[] weights = {2, 3, 4, 5};
    int[] values = {3, 4, 5, 6};
    int capacity = 5;
    int maxValue = knapsack.maxProfit(weights, values, capacity, 0);
    System.out.println("Maximum value: " + maxValue);
  }
}

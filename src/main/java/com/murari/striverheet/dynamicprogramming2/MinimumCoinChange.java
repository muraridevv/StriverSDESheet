package com.murari.striverheet.dynamicprogramming2;

public class MinimumCoinChange {

  public int coinChange(int[] coins, int amount) {
    int row = coins.length + 1;
    int col = amount + 1;
    int[][] dp = new int[row][col];

    // Initialize the first row of the DP table
    for (int j = 1; j < col; j++) {
      dp[0][j] = Integer.MAX_VALUE; // Initialize with a large value
    }
    dp[0][0] = 0; // Base case: 0 coins are needed to make amount 0

    // Fill the DP table
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) { // Start from j=1
        if (j < coins[i - 1]) {
          // If the amount is less than the current coin denomination,
          // we cannot use this coin. So, take the value from the row above.
          dp[i][j] = dp[i - 1][j];
        } else {
          // Otherwise, consider whether to use the current coin denomination
          // or not, and take the minimum of the two.
          dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
        }
      }
    }
    return dp[row - 1][col - 1] == Integer.MAX_VALUE ? -1 : dp[row - 1][col - 1];
  }

  public static void main(String[] args) {
    MinimumCoinChange coinChange = new MinimumCoinChange();

    // Example usage:
    int[] coins = {1};
    int amount = 0;
    int minCoins = coinChange.coinChange(coins, amount);
    System.out.println("Minimum number of coins required: " + minCoins);
  }
}

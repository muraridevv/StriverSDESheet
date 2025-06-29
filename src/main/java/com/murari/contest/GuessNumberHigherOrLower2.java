package com.murari.contest;

public class GuessNumberHigherOrLower2 {
  public int getMoneyAmount(int n) {
    return dfs(1, n);
  }

  private int dfs(int start, int end) {
    if (start >= end) return 0;
    int result = Integer.MAX_VALUE;
    for (int i = start; i <= end; i++) {
      int left = dfs(start, i - 1);
      int right = dfs(i + 1, end);
      int currentCost = i + Math.max(left, right);
      result = Math.min(result, currentCost);
    }
    return result;
  }

  public int getMoneyAmountOptimized(int n) {
    int[][] dp = new int[n + 1][n + 1];
    return dfsOptimized(1, n, dp);
  }

  private int dfsOptimized(int start, int end, int[][] dp) {
    if (start >= end) return 0;
    if (dp[start][end] != 0) return dp[start][end];
    int result = Integer.MAX_VALUE;
    for (int i = start; i <= end; i++) {
      int left = dfsOptimized(start, i - 1, dp);
      int right = dfsOptimized(i + 1, end, dp);
      int currentCost = i + Math.max(left, right);
      result = Math.min(result, currentCost);
    }
    dp[start][end] = result;
    return result;
  }

  public static void main(String[] args) {
    GuessNumberHigherOrLower2 obj = new GuessNumberHigherOrLower2();

    System.out.println(obj.getMoneyAmountOptimized(10));
  }
}

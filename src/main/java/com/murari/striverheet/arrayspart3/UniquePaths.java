package com.murari.striverheet.arrayspart3;

public class UniquePaths {
  public int uniquePaths(int m, int n) {
    int N = m + n - 2;
    int r = m - 1;
    int result = 1;

    for (int i = 1; i <= r; i++) {
      result = result * (N - r + i) / i;
    }
    return result;
  }

  public int uniquePathsDP(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    UniquePaths uniquePaths = new UniquePaths();
    int m = 3;
    int n = 7;
    System.out.println(uniquePaths.uniquePathsDP(m, n));
  }
}

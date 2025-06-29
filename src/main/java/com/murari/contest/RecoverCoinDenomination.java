package com.murari.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecoverCoinDenomination {
  public static int[] recover(int[] numWays) {
    int n = numWays.length;
    List<Integer> result = new ArrayList<>();
    int[] dp = new int[n + 1];
    dp[0] = 1; // Base case: 1 way to make amount 0

    for (int coin = 1; coin <= n; coin++) {
      int[] tempDp = Arrays.copyOf(dp, n + 1);

      // Simulate adding coin
      for (int amount = coin; amount <= n; amount++) {
        tempDp[amount] += tempDp[amount - coin];
      }

      // Validate: does not exceed original numWays
      boolean isValid = true;
      for (int i = 1; i <= n; i++) {
        if (tempDp[i] > numWays[i - 1]) {
          isValid = false;
          break;
        }
      }

      if (isValid) {
        result.add(coin);
        dp = tempDp; // Accept this coin
      }
    }

    // Final exact match check
    for (int i = 1; i <= n; i++) {
      if (dp[i] != numWays[i - 1]) return new int[0];
    }

    return result.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    int[] input1 = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5};
    int[] input2 = {1, 2, 2, 3, 4};
    int[] input3 = {1, 2, 3, 4, 15};

    System.out.println(Arrays.toString(recover(input1))); // [2, 4, 6]
    System.out.println(Arrays.toString(recover(input2))); // [1, 2, 5]
    System.out.println(Arrays.toString(recover(input3))); // []
  }
}

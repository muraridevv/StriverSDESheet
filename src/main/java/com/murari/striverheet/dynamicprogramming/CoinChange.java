package com.murari.striverheet.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, Integer amount){
        int m= coins.length;
        int[][] dp= new int[m+1][amount+1];

        //initialise the array
        for(int i=0; i<=m; i++){
            Arrays.fill(dp[i], amount+1);
        }

        for(int i=0; i<=m; i++){
            dp[i][0]=0; // No coins needed to make amount 0
        }

        //Fill the dp array
        for(int i=1; i<=m; i++){
            for(int j=1; j<= amount; j++){
                if(coins[i-1]<=j){
                    dp[i][j]= Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                } else {
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        return dp[m][amount]>amount? -1: dp[m][amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Fewest coins needed: " + cc.coinChange(coins1, amount1)); // Output: 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Fewest coins needed: " + cc.coinChange(coins2, amount2)); // Output: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Fewest coins needed: " + cc.coinChange(coins3, amount3)); // Output: 0
    }
}

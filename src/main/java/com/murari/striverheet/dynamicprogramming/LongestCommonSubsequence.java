package com.murari.striverheet.dynamicprogramming;

public class LongestCommonSubsequence {

    public int longestCommonSubsequenceRecursion(String text1, String text2) {
        return lcs(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    private int lcs(String text1, String text2, int i, int j){
        //Base case: If any of the strings becomes empty
        if(i<0 || j<0){
            return 0;
        }

        //Case 1: If current character matches
        if(text1.charAt(i)== text2.charAt(j)){
            //Include the current character in the subsequenc and move to previous character
            return 1+lcs(text1, text2, i-1, j-1);
        } else {
            //Case 2: If current character doesn't match
            //Skip one character either from text1 or from text2 and contnue exploring
            int skipText1= lcs(text1, text2, i-1, j);
            int skipText2= lcs(text1, text2, i, j-1);
            // Return the maximum lenght of the common subsequence from both the choices
            return 0+ Math.max(skipText1, skipText2);
        }
    }

    public int longestCommonSubsequenceTabular(String text1, String text2) {
        int[][] dp= new int[text1.length()+1][text2.length()+1];

        //Fill the dp table using bottom up approach
        for(int i=1; i<=text1.length(); i++){
            for(int j=1; j<= text2.length(); j++){
                if(text1.charAt(i-1)== text2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1]+1; // character matches, increament it by 1.
                } else {
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp= new int[text2.length()+1];

        //Fill the dp table using bottom up approach
        for(int i=1; i<=text1.length(); i++){
            int prev=0;
            for(int j=1; j<= text2.length(); j++){
                int temp= dp[j];
                if(text1.charAt(i-1)== text2.charAt(j-1)){
                    dp[j]= prev+1; // character matches, increament it by 1.
                } else {
                    dp[j]= Math.max(dp[j], dp[j-1]);
                }
                prev= temp;
            }
        }
        return dp[text2.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int length = lcs.longestCommonSubsequence(text1, text2);
        System.out.println("Length of Longest Common Subsequence: " + length);
    }
}

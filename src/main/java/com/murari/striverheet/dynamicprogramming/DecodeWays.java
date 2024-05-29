package com.murari.striverheet.dynamicprogramming;

public class DecodeWays {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int n=s.length();
        int[] dp= new int[n+1];

        //Base case
        dp[0]= 1;
        dp[1]= 1;

        for(int i=2; i<=n; i++){
            int oneDigit= Integer.parseInt(s.substring(i-1,i));
            int twoDigit= Integer.parseInt(s.substring(i-2,i));
            if(oneDigit>0 && oneDigit<=9) {
                dp[i] += dp[i - 1];
            }
            if(twoDigit>=10 && twoDigit<=26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        DecodeWays decode= new DecodeWays();
//        String s="226";
//        String s="06";
//        String s="12";
        String s="27";

        System.out.println("No of ways to decode: "+ decode.numDecodings(s));
    }
}

package com.murari.contest;
//https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";

        int gcdLength= gcd(str1.length(), str2.length());

        return str1.substring(0,gcdLength);
    }

    private int gcd(int a, int b){
        while (b!=0){
            int remainder= a%b;
            a=b;
            b= remainder;
        }
        return a;
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings obj= new GreatestCommonDivisorOfStrings();
        String word1= "ABCABC";
        String word2="ABC";
        System.out.println(obj.gcdOfStrings(word1,word2));

        String word3= "ABABAB";
        String word4="ABAB";
        System.out.println(obj.gcdOfStrings(word3,word4));

        String word5= "LEET";
        String word6="CODE";
        System.out.println(obj.gcdOfStrings(word5,word6));
    }
}

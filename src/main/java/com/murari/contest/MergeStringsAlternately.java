package com.murari.contest;

//https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result= new StringBuilder();
        int length= Math.min(word1.length(), word2.length());
        for(int i=0;i< length;i++){
            result.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if(word1.length()>length){
            result.append(word1.substring(length));
        }
        if(word2.length()>length){
            result.append(word2.substring(length));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately obj= new MergeStringsAlternately();
        String word1= "abc";
        String word2="pqr";
        System.out.println(obj.mergeAlternately(word1,word2));

        String word3= "ab";
        String word4="pqrs";
        System.out.println(obj.mergeAlternately(word3,word4));

        String word5= "abcd";
        String word6="pq";
        System.out.println(obj.mergeAlternately(word5,word6));
    }
}

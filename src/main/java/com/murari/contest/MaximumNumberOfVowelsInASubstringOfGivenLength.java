package com.murari.contest;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int maxVowel=0;
        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))) maxVowel++;
        }

        int currentVowel= maxVowel;
        for(int i= k; i< s.length();i++){
            if(isVowel(s.charAt(i))) currentVowel++;
            if(isVowel(s.charAt(i-k))) currentVowel--;
            maxVowel=Math.max(currentVowel, maxVowel);
        }
        return maxVowel;
    }

    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength obj= new MaximumNumberOfVowelsInASubstringOfGivenLength();
        String s = "abciiidef";
        int k=3;
        System.out.println(obj.maxVowels(s,k));
    }
}

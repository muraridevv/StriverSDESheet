package com.murari.striverheet.string;

public class ReverseWord {

    public static String reverseWords(String s) {
        String[] strArr= s.split("\\s+");
        int i= strArr.length-1;
        StringBuilder reversedStr= new StringBuilder();
        while(i>=0){
            reversedStr.append(strArr[i]).append(" ");
            i--;
        }
        return reversedStr.toString().trim();
    }

    public static void main(String[] args) {
        String s= "  hello world  ";
        String reversedString= reverseWords(s);
        System.out.println("Reversed string is :"+reversedString);
    }
}

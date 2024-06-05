package com.murari.striverheet.string;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x!= Math.abs(x)) return false;

        int xImage=x;
        int reversedX=0;
        while(xImage!=0){
            int digit= xImage%10;
            reversedX= reversedX*10 + digit;
            xImage/=10;
        }
        return x==reversedX;
    }

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        int n1 = 121;
        System.out.println("The number is palindrome: "+solution.isPalindrome(n1));
    }
}

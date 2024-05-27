package com.murari.striverheet.bits;

public class ReverseBits {
    public int reverseBits(int n) {
       int result=0;

       for(int i=0; i< 32; i++){
           //extract ith bit from n
           int bit= (n>>i) & 1;

           //set (31-1)th bit in result
           int reverseBit= bit<<(31-i);
           result= result| reverseBit;
       }
       return result;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();

        int n1 = 0b00000010100101000001111010011100;
        int reversed1 = reverseBits.reverseBits(n1);
        System.out.println("Input: " + Integer.toBinaryString(n1) + ", Reversed: " + reversed1 + " (" + Integer.toBinaryString(reversed1) + ")");

        int n2 = 0b11111111111111111111111111111101;
        int reversed2 = reverseBits.reverseBits(n2);
        System.out.println("Input: " + Integer.toBinaryString(n2) + ", Reversed: " + reversed2 + " (" + Integer.toBinaryString(reversed2) + ")");
    }
}

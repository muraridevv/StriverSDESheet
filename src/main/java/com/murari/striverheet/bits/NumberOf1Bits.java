package com.murari.striverheet.bits;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count= 0;
        while (n>0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits= new NumberOf1Bits();
        int number=8;
        System.out.println("No. of 1 bits in "+number+" : "+numberOf1Bits.hammingWeight(number));
    }
}

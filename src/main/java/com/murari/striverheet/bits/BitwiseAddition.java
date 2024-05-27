package com.murari.striverheet.bits;

public class BitwiseAddition {

    public int add(int a, int b){
        while (b!= 0){
            int carry= a & b;   //This line calculates the carry. The bitwise AND (&) operation finds the bits that are set (1) in both a and b. These are the positions where a carry will occur.

            a= a ^ b;   //This line calculates the sum without the carry. The bitwise XOR (^) operation adds the bits of a and b without considering the carry.

            b= carry<<1;    //This line shifts the carry to the left by one position, preparing it to be added in the next iteration.

        }
        return a;
    }

    public static void main(String[] args) {
        BitwiseAddition addition= new BitwiseAddition();
        int a = 5;
        int b = 7;

        int sum = addition.add(a, b);

        System.out.println("Sum of " + a + " and " + b + " is: " + sum);
    }

}

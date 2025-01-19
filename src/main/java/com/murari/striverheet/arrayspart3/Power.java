package com.murari.striverheet.arrayspart3;

public class Power {

    // Method to calculate x raised to the power n
    public double myPow(double x, int n) {
        if (n == 0) return 1;  // Base case: any number raised to the power of 0 is 1

        if (n < 0) {  // If the power is negative
            return 1 / x * myPow(1 / x, -(n + 1));  // Convert to positive power, adjust for division
        }

        // Recursively calculate the power using divide-and-conquer
        return (n % 2 == 0) ?
                myPow(x * x, n / 2) :
                x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        Power obj = new Power();

        // Test case: 2 raised to the power of 10
        double base = 2.0;
        int exponent = 10;

        // Call the myPow method and store the result
        double result = obj.myPow(base, exponent);

        // Print the result
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);

        // Another test case: 2 raised to the power of -3
        base = 2.0;
        exponent = -3;

        // Call the myPow method and print the result
        result = obj.myPow(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
}

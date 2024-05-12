package com.murari.striverheet.contest;

import java.util.*;

public class MinimumLengthOfAnagramConcatenation {
    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "cdef";

        System.out.println(minimumLengthOfAnagramConcatenation(s1)); // Output: 2
        System.out.println(minimumLengthOfAnagramConcatenation(s2)); // Output: 4
    }

    public static int minimumLengthOfAnagramConcatenation(String s) {
        Map<Character, Integer> countMap = new HashMap<>();

        // Count occurrences of each character in the string
        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // Find the GCD of counts
        int gcd = countMap.values().iterator().next();
        for (int count : countMap.values()) {
            gcd = gcd(gcd, count);
        }

        // Calculate the minimum length of t
        int minLength = 0;
        for (int count : countMap.values()) {
            minLength += count / gcd;
        }

        return minLength;
    }

    // Method to find the greatest common divisor (GCD) of two numbers
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}


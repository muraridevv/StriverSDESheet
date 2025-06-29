package com.murari.contest;

// https://leetcode.com/problems/maximum-swap/description/
public class MaximumSwap {

  public int maximumSwap(int num) {
    char[] digits = Integer.toString(num).toCharArray();
    int[] lastIndex = new int[10];

    for (int i = 0; i < digits.length; i++) {
      lastIndex[digits[i] - '0'] = i;
    }
    // Try to find a better digit
    for (int i = 0; i < digits.length; i++) {
      int currentDigit = digits[i] - '0';

      // Look for a bigger digit and swap with current
      for (int d = 9; d > currentDigit; d--) {
        if (lastIndex[d] > i) {
          // swap and return result
          char temp = digits[i];
          digits[i] = digits[lastIndex[d]];
          digits[lastIndex[d]] = temp;
          return Integer.parseInt(new String(digits));
        }
      }
    }
    return num;
  }

  public static void main(String[] args) {
    MaximumSwap solution = new MaximumSwap();
    System.out.println(solution.maximumSwap(2736)); // Output: 7236
    System.out.println(solution.maximumSwap(9973)); // Output: 9973
    System.out.println(solution.maximumSwap(98368)); // Output: 9973
  }
}

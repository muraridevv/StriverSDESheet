package com.murari.striverheet.bits;

public class CountBits {

  public int[] countBits(int n) {
    int[] result = new int[n + 1];
    result[0] = 0;
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        result[i] = result[i / 2];
      } else {
        result[i] = result[i / 2] + 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    CountBits countBits = new CountBits();
    int number = 8;
    System.out.println("No. of 1 bits in " + number + " : " + countBits.countBits(number));
  }
}

package com.murari.contest;

public class GoodInteger {
  public int rotatedDigits(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (isGoodInteger(i)) count++;
    }
    return count;
  }

  private boolean isGoodInteger(int n) {
    boolean hasDifferentDigit = false;

    while (n > 0) {
      int digit = n % 10;
      if (digit == 3 || digit == 4 || digit == 7) return false;
      else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
        hasDifferentDigit = true;
      }
      n = n / 10;
    }
    return hasDifferentDigit;
  }

  public static void main(String[] args) {
    GoodInteger obj = new GoodInteger();
    System.out.println(obj.rotatedDigits(10));
    System.out.println(obj.rotatedDigits(1));
  }
}

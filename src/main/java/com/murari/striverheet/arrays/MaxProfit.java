package com.murari.striverheet.arrays;

public class MaxProfit {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;

    for (int price : prices) {
      minPrice = Math.min(price, minPrice);
      maxProfit = Math.max(price - minPrice, maxProfit);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] list = new int[] {7, 1, 5, 3, 6, 4};
    MaxProfit obj1 = new MaxProfit();
    System.out.println(obj1.maxProfit(list));
  }
}

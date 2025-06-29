package com.murari.contest;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

  public static int totalFruit(int[] fruits) {
    int start = 0;
    int max = 0;

    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int end = 0; end < fruits.length; end++) {
      freqMap.put(fruits[end], freqMap.getOrDefault(fruits[end], 0) + 1);
      while (freqMap.size() > 2) {
        freqMap.put(fruits[start], freqMap.get(fruits[start]) - 1);
        if (freqMap.get(fruits[start]) == 0) {
          freqMap.remove(fruits[start]);
        }
        start++;
      }
      max = Math.max(max, end - start + 1);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] fruits1 = {1, 2, 1};
    int[] fruits2 = {0, 1, 2, 2};
    int[] fruits3 = {1, 2, 3, 2, 2};
    int[] fruits4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

    //        System.out.println("Max fruits collected: " + totalFruit(fruits1)); // 3
    //        System.out.println("Max fruits collected: " + totalFruit(fruits2)); // 3
    //        System.out.println("Max fruits collected: " + totalFruit(fruits3)); // 4
    System.out.println("Max fruits collected: " + totalFruit(fruits4)); // 5
  }
}

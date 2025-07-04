package com.murari.contest;

public class KthCharacter {

  public char kthCharacter(int k) {
    StringBuilder word = new StringBuilder();
    word.append("a");

    while (word.length() < k) {
      char[] charArray = word.toString().toCharArray();
      StringBuilder tempWord = new StringBuilder();
      for (char ch : charArray) {
        tempWord.append(++ch);
      }
      word.append(tempWord);
    }
    return word.charAt(k - 1);
  }

  public static void main(String[] args) {
    KthCharacter obj = new KthCharacter();
    System.out.println(obj.kthCharacter(5));
    System.out.println(obj.kthCharacter(10));
  }
}

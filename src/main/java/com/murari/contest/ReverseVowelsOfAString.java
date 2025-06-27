package com.murari.contest;

import java.util.Set;

public class ReverseVowelsOfAString {
  public String reverseVowels(String s) {
    Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    char[] charArr = s.toCharArray();
    int leftIdx = 0;
    int rightIdx = s.length() - 1;

    while (leftIdx < rightIdx) {
      if (vowelSet.contains(charArr[leftIdx]) && vowelSet.contains(charArr[rightIdx])) {
        swap(charArr, leftIdx, rightIdx);
        leftIdx++;
        rightIdx--;
      } else if (vowelSet.contains(charArr[leftIdx])) rightIdx--;
      else leftIdx++;
    }
    return new String(charArr);
  }

  public void swap(char[] charArr, int leftIdx, int rightIdx) {
    char temp = charArr[leftIdx];
    charArr[leftIdx] = charArr[rightIdx];
    charArr[rightIdx] = temp;
  }

  public static void main(String[] args) {
    ReverseVowelsOfAString obj = new ReverseVowelsOfAString();
    String s = "IceCreAm";
    System.out.println(obj.reverseVowels(s));
  }
}

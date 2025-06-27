package com.murari.contest;

public class RemoveStarsFromAString {

  public String removeStars(String s) {
    StringBuilder result = new StringBuilder();

    for (Character ch : s.toCharArray()) {

      if (ch == '*') {
        if (!result.isEmpty()) result.deleteCharAt(result.length() - 1);
      } else result.append(ch);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    RemoveStarsFromAString obj = new RemoveStarsFromAString();
    String s = "leet**cod*e";
    System.out.println(obj.removeStars(s));
  }
}

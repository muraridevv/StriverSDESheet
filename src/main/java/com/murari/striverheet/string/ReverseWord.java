package com.murari.striverheet.string;

public class ReverseWord {

  public static String reverseWords(String s) {
    String[] wordsList = s.split("\\s+");
    StringBuilder result = new StringBuilder();
    for (int i = wordsList.length - 1; i >= 0; i--) {
      result.append(wordsList[i].trim()).append(" ");
    }
    return result.toString().trim();
  }

  public static void main(String[] args) {
    //        String s= "  hello world  ";
    String s = "a good   example";
    String reversedString = reverseWords(s);
    System.out.println("Reversed string is :" + reversedString);
  }
}

package com.murari.striverheet.contest;

public class ValidWord {

  public boolean isValid(String word) {
    if (word.length() < 3) return false;

    boolean isVowel = false;
    boolean isConsonent = false;

    for (char ch : word.toCharArray()) {
      if (Character.isLetter(ch)) {
        if (isVowel(ch) && !isVowel) {
          isVowel = true;
        } else if (!isVowel(ch) && !isConsonent) {
          isConsonent = true;
        }
      } else if (Character.isDigit(ch)) {

      } else {
        return false;
      }
    }

    return isVowel && isConsonent;
  }

  private boolean isVowel(char ch) {
    ch = Character.toLowerCase(ch);
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }

  public static void main(String[] args) {
    ValidWord validWord = new ValidWord();
    String[] words = {"234Adas", "UuE6", "OpenAI", "123", "ab", "a", ""};

    for (String word : words) {
      System.out.println("Word: " + word + ", isValid: " + validWord.isValid(word));
    }
  }
}

package com.murari.contest;

// Suppose guess API is defined externally like this:
class GuessGame {
  int pick;

  public GuessGame(int pick) {
    this.pick = pick;
  }

  public int guess(int num) {
    return Integer.compare(pick, num);
  }
}

public class GuessNumber extends GuessGame {

  public GuessNumber(int pick) {
    super(pick);
  }

  public int guessNumber(int n) {
    int low = 1, high = n;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int result = guess(mid);

      if (result == 0) return mid;
      else if (result > 0) low = mid + 1;
      else high = mid - 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    GuessNumber game1 = new GuessNumber(6);
    System.out.println(game1.guessNumber(10)); // Output: 6

    GuessNumber game2 = new GuessNumber(1);
    System.out.println(game2.guessNumber(1)); // Output: 1

    GuessNumber game3 = new GuessNumber(1);
    System.out.println(game3.guessNumber(2)); // Output: 1
  }
}

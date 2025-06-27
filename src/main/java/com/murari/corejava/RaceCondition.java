package com.murari.corejava;

public class RaceCondition {

  public static void main(String[] args) {}
}

class IncrementerThread extends Thread {
  private int iterations;
  private volatile int x;

  private IncrementerThread(int iterations) {
    this.iterations = iterations;
  }

  @Override
  public void run() {
    for (int i = 0; i < iterations; i++) {
      int temp = x;
      temp++;
      x = temp;
    }
  }

  public int getX() {
    return x;
  }
}

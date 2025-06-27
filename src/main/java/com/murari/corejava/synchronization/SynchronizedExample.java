package com.murari.corejava.synchronization;

public class SynchronizedExample {

  private int count = 0;

  public void increment() {
    count++;
  }

  public void decrement() {
    count--;
  }

  public synchronized int getCount() {
    return count;
  }

  public static void main(String[] args) {
    SynchronizedExample synchronizedExample = new SynchronizedExample();

    Thread incrementThread =
        new Thread(
            () -> {
              for (int i = 0; i < 10000; i++) {
                synchronizedExample.increment();
              }
            });

    Thread decrementThread =
        new Thread(
            () -> {
              for (int i = 0; i < 10000; i++) {
                synchronizedExample.decrement();
              }
            });

    incrementThread.start();
    decrementThread.start();

    try {
      incrementThread.join();
      decrementThread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Final count" + synchronizedExample.count);
  }
}

package com.murari.corejava.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

  private AtomicInteger count = new AtomicInteger();

  public void increment() {
    count.incrementAndGet();
  }

  public void decrement() {
    count.decrementAndGet();
  }

  public int getCount() {
    return count.get();
  }

  public static void main(String[] args) {

    AtomicExample atomicExample = new AtomicExample();
    Thread incrementThread =
        new Thread(
            () -> {
              for (int i = 0; i < 10000; i++) {
                atomicExample.increment();
              }
            });

    Thread decrementThread =
        new Thread(
            () -> {
              for (int i = 0; i < 10000; i++) {
                atomicExample.decrement();
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
    System.out.println("Final count" + atomicExample.getCount());
  }
}

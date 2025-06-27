package com.murari.striverheet.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

  public static void main(String[] args) {
    MyStack stack = new MyStack();
  }
}

class MyStack {

  private Queue<Integer> queue;

  public MyStack() {
    queue = new LinkedList<>();
  }

  public void push(int x) {
    queue.offer(x);
    int size = queue.size();

    // rotate the queue so that newly added element comes to front
    for (int i = 0; i < size - 1; i++) {
      queue.offer(queue.poll());
    }
  }

  // Removes the element on top of the stack and returns that element
  public int pop() {
    return queue.poll();
  }

  public int top() {
    return queue.peek();
  }

  public boolean empty() {
    return queue.isEmpty();
  }
}

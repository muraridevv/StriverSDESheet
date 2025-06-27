package com.murari.striverheet.stackandqueue;

public class QueueImpl {

  public static void main(String[] args) {
    Queue queue = new Queue(10);
    System.out.println("is empty? :" + queue.isEmpty());
    System.out.println("is full? :" + queue.isFull());
    queue.enqueue(1);
    queue.enqueue(4);
    queue.enqueue(3);
    queue.dequeue();
  }
}

class Queue {
  private int maxSize;
  private int[] queueArray;
  private int front;
  private int rear;
  private int currentSize;

  // constructor to initialize the queue
  public Queue(int maxSize) {
    this.maxSize = maxSize;
    this.queueArray = new int[maxSize];
    this.front = 0;
    this.rear = -1;
    this.currentSize = 0;
  }

  // method to check if queue is empty
  public boolean isEmpty() {
    return currentSize == 0;
  }

  // method to check if queue is full
  public boolean isFull() {
    return currentSize == maxSize;
  }

  public int size() {
    return currentSize;
  }

  // method to add element to queue
  public void enqueue(int num) {
    if (isFull()) {
      System.out.println("Queue is full. Cannot add element");
      return;
    }
    rear = (rear + 1) % maxSize;
    queueArray[rear] = num;
    currentSize++;
  }

  public int dequeue() {
    if (isEmpty()) {
      System.out.println("Queue is empty. Cannot remove element");
      return -1;
    }
    int removedItem = queueArray[front];
    front = (front + 1) % maxSize;
    currentSize--;
    return removedItem;
  }
}

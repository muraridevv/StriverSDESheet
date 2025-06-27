package com.murari.striverheet.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

  private PriorityQueue<Integer> minHeap;
  private PriorityQueue<Integer> maxHeap;

  public MedianFinder() {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {
    // Add the element to maxHeap
    maxHeap.offer(num);

    // Move the maximum element from maxHeap to minHeap
    minHeap.offer(maxHeap.poll());

    // Balance the size of Heap
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
  }

  public double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    } else {
      return maxHeap.peek();
    }
  }

  public static void main(String[] args) {
    // Example usage
    MedianFinder obj = new MedianFinder();
    obj.addNum(1);
    obj.addNum(2);
    double median = obj.findMedian(); // Returns 1.5
    System.out.println("Median: " + median);
    obj.addNum(3);
    obj.addNum(5);
    obj.addNum(10);
    obj.addNum(7);
    median = obj.findMedian(); // Returns 2
    System.out.println("Median: " + median);
  }
}

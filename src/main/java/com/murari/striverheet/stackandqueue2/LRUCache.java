package com.murari.striverheet.stackandqueue2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private Map<Integer, Node> cache;
  private int capacity;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.cache = new HashMap<>(capacity);
    this.capacity = capacity;
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    return -1;
  }

  public void put(int key, int value) {}

  class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}

package com.murari.striverheet.linkedlistpart2;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    Set<ListNode> nodeSet = new HashSet<>();

    while (head != null) {
      if (nodeSet.contains(head)) {
        return true;
      }
      nodeSet.add(head);
      head = head.next;
    }

    return false;
  }

  public boolean hasCycleOptimized(ListNode head) {

    if (head == null || head.next == null) return false;
    ListNode slowNode = head;
    ListNode fastNode = head.next;

    while (fastNode != null && fastNode.next != null) {
      if (slowNode == fastNode) return true;

      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }

    return false;
  }
}

package com.murari.striverheet.linkedlist;

public class DeleteNode {

  public void deleteNode(ListNode node) {
    if (node != null) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }
}

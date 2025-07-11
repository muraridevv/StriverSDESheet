package com.murari.striverheet.linkedlist;

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode currNode = result;

    int carry = 0;

    while (l1 != null || l2 != null) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      carry = sum / 10;
      sum = sum % 10;
      currNode.next = new ListNode(sum);
      currNode = currNode.next;
    }

    if (carry == 1) {
      currNode.next = new ListNode(1);
    }

    return result.next;
  }
}

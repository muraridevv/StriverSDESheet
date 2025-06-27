package com.murari.striverheet.linkedlist;

//  Definition for singly-linked list.

public class ReverseList {
  public ListNode reverseListIterative(ListNode head) {
    ListNode previous = null;
    ListNode current = head;
    while (current != null) {
      ListNode nextOff = current.next; // store the next node
      current.next = previous; // reverse the link
      previous = current; // move previous to current node
      current = nextOff; // move current to next node
    }
    return previous;
  }

  public static ListNode reverseListRecursive(ListNode head) {
    // Base case: if the list is empty or has only one node
    if (head == null || head.next == null) {
      return head;
    }

    // Reverse the rest of the list recursively
    ListNode reversed = reverseListRecursive(head.next);

    // Reverse the link between the current node and the next node
    head.next.next = head;
    head.next = null;

    // Return the new head of the reversed list
    return reversed;
  }

  public static void main(String[] args) {
    // Create a linked list with values 1, 3, 2, and 4
    ListNode head = new ListNode(1);
    head.next = new ListNode(3);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(4);

    // Print the original linked list
    System.out.print("Original Linked List: ");
    //        printLinkedList(head);

    // Reverse the linked list
    head = reverseListRecursive(head);

    // Print the reversed linked list
    System.out.print("Reversed Linked List: ");
    //        printLinkedList(head);
  }
}

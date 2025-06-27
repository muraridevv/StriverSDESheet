package com.murari.striverheet.linkedlistpart2;

import java.util.Stack;

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {

    Stack<Integer> linkedStack = new Stack<>();
    ListNode current = head;
    while (current != null) {
      linkedStack.push(current.val);
      current = current.next;
    }
    ListNode reverseCurrent = head;
    while (reverseCurrent != null) {
      if (reverseCurrent.val != linkedStack.pop()) return false;
      reverseCurrent = reverseCurrent.next;
    }

    return true;
  }

  public boolean isPalindromeOptimized(ListNode head) {
    // Initialize pointers: slow and fast to head of the linked list
    ListNode slow = head, fast = head;
    ListNode prev = null, temp;

    // Move slow and fast pointers until fast reaches the end or null
    // Slow pointer will be at the middle (or middle-left if length is even)
    while (fast != null && fast.next != null) {
      prev = slow; // Save the node before the middle for splitting
      slow = slow.next; // Move slow one step forward
      fast = fast.next.next; // Move fast two steps forward
    }

    // Split the list into two parts at the middle node
    prev.next = null;

    // Reverse the second half of the linked list
    while (slow != null) {
      temp = slow.next; // Store the next node of slow
      slow.next = prev; // Reverse the pointer of slow to point to the previous node
      prev = slow; // Move prev to the current node (slow)
      slow = temp; // Move slow to the next node
    }

    // Reset fast to head and slow to the reversed second half (prev)
    fast = head;
    slow = prev;

    // Compare elements of the first half and reversed second half
    while (slow != null) {
      // If values don't match, linked list is not a palindrome
      if (fast.val != slow.val) return false;
      // Move fast and slow pointers forward
      fast = fast.next;
      slow = slow.next;
    }

    // If all elements match, linked list is a palindrome
    return true;
  }
}

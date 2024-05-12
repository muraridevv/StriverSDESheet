package com.murari.striverheet.linkedlistpart2;

public class CycleFirstNode {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If the list has 0 or 1 node, it cannot have a cycle
        }

        // Use slow and fast pointers to detect a loop in the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by 1 step
            fast = fast.next.next;   // Move fast pointer by 2 steps

            if (slow == fast) {      // If slow and fast pointers meet, there's a cycle
                break;
            }
        }

        // If there's no cycle, return null
        if (fast == null || fast.next == null) {
            return null;
        }

        // Move one pointer to the head and another from the meeting point at the same speed
        ListNode entry = head;
        while (entry != slow) {
            entry = entry.next;
            slow = slow.next;
        }

        // Return the node where both pointers meet, which is the start of the cycle
        return entry;
    }

}

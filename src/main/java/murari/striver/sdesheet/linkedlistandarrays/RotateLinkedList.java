package murari.striver.sdesheet.linkedlistandarrays;

public class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // No rotation needed
        }

        int length = 1; // Length of the list
        ListNode current = head;

        // Calculate the length of the list
        while (current.next != null) {
            length++;
            current = current.next;
        }

        // Make the list circular
        current.next = head;

        // Adjust k to avoid unnecessary rotations
        k = k % length;

        // Find the new head position after rotation
        int end = length - k;
        while (end > 1) {
            head = head.next;
            end--;
        }

        // Set the new head and break the circular connection
        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }

/*
Example:
Suppose we have the following linked list:
1 -> 2 -> 3 -> 4 -> 5

And let's say k = 2.

After rotation, the expected output is:
4 -> 5 -> 1 -> 2 -> 3

Step-by-step process:
1. Calculate Length and Make Circular:
   length = 5
   Circular list: 1 -> 2 -> 3 -> 4 -> 5 -┐
                                            |
                                          <-┘

2. Adjust k:
   k = 2 % 5 = 2

3. Find New Head Position:
   end = length - k = 5 - 2 = 3
   Move head pointer to node at index 3:
   1 -> 2 -> 3 -> 4 -> 5
             ^
             |
            head

4. Set New Head and Break Circular Connection:
   New head: 4
   1 -> 2 -> 3    4 -> 5
             ^    ^
             |    |
            head  newHead
   Set next of current head to null:
   1 -> 2 -> 3    4 -> 5
             ^        ^
             |        |
            head     newHead

5. Return New Head:
   4 -> 5 -> 1 -> 2 -> 3
*/


}

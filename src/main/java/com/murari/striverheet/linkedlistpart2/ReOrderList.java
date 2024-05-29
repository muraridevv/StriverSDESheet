package com.murari.striverheet.linkedlistpart2;

//  https://leetcode.com/problems/reorder-list/
public class ReOrderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        //find the mid of linkedList
        ListNode slowNode= head;
        ListNode fastNode= head;
        while(fastNode!=null && fastNode.next != null){
            slowNode= slowNode.next;
            fastNode= fastNode.next.next;
        }


        // Reverse the 2nd half
        ListNode current= slowNode;
        ListNode previous= null;
        while(current!=null){
            ListNode nextOff= current.next;
            current.next=previous;
            previous=current;
            current= nextOff;
        }
        // merge both the list
        ListNode first= head;
        ListNode second= previous;
        while (second.next!=null){
            ListNode temp1= first.next;
            ListNode temp2= second.next;
            first.next=second;
            second.next= temp1;
            first= temp1;
            second= temp2;

        }
    }

    // Helper method to create a linked list from an array
    public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print a linked list
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

        public static void main(String[] args) {
            ReOrderList solution = new ReOrderList();

            // Example usage
            int[] arr = {1, 2, 3, 4, 5};
            ListNode head = solution.createLinkedList(arr);
            System.out.println("Original list:");
            solution.printLinkedList(head);
            solution.reorderList(head);
            System.out.println("Reordered list:");
            solution.printLinkedList(head);
    }
}

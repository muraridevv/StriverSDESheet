package com.murari.striverheet.linkedlist;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowNode= head;
        ListNode fastNode = head;

        // move the fastNode to n nodes ahead
        for(int i=0;i<n;i++){
            fastNode=fastNode.next;
        }

        // If fastNode becomes null, the Nth node from the end is the head
        if(fastNode.next==null){
            return head.next;
        }
        // move both nodes simultaneously until fastNode reaches the end
        while (fastNode!=null){
            slowNode=slowNode.next;
            fastNode=fastNode.next;
        }
        slowNode.next=slowNode.next.next;
        return head;
    }
}

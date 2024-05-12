package com.murari.striverheet.linkedlistpart2;


import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> searchNode= new HashSet<>();

        while(headA!=null){
            //do the logic
            searchNode.add(headA);
            headA=headA.next;
        }

        while (headB!=null){
            //perform the logic
            if(searchNode.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {
        // Initialize pointers a and b to the heads of the input linked lists
        ListNode a = headA;
        ListNode b = headB;

        // Iterate until a and b point to the same node (intersection) or both reach the end
        while (a != b) {
            // If a reaches the end of its list, redirect it to the head of the other list
            a = (a == null) ? headB : a.next;
            // If b reaches the end of its list, redirect it to the head of the other list
            b = (b == null) ? headA : b.next;
        }

        // Return the intersection node (or null if no intersection)
        return a;
    }

}

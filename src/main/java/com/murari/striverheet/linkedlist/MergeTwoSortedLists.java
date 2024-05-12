package com.murari.striverheet.linkedlist;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current= dummy;

        while (list1!=null && list2!= null){
            //merge the list
            if(list1.val<= list2.val){
                current.next=list1;
                list1=list1.next;
            } else{
                current.next= list2;
                list2= list2.next;
            }
            current=current.next;
        }
        current.next= list1!=null?list1:list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
//        list1.next.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
//        list2.next.next.next = new ListNode(4);

        mergeTwoLists(list1, list2);
    }
}

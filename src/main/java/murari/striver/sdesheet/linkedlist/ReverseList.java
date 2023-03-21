package murari.striver.sdesheet.linkedlist;


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode currNode=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=currNode;
            currNode=head;
            head=next;
        }
        return currNode;
    }
}

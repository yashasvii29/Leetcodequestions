/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    if(head==null||head.next==null) 
        return head;
      ListNode dummynode=new ListNode(-1);
      ListNode prev=dummynode;
      dummynode.next=head;
      for(int i=0;i<left-1;i++){ //range find krenge
        prev=prev.next;
      }
      ListNode curr=prev.next;
      
      for(int i=0;i<right-left;i++){
        ListNode ahead=curr.next;
        curr.next=ahead.next;
        ahead.next=prev.next;
        prev.next=ahead;
      }
      return dummynode.next;
    }   
}

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
    public ListNode doubleIt(ListNode head) {
        ListNode rev = reverseList(head);
        ListNode dummy=new ListNode(0);
        ListNode current = dummy; 
        int carry=0;
    
        while(rev!=null){
            int data=rev.val;
            data=data*2;
            int rem=carry+(data%10);
             carry=data/10;
            current.next = new ListNode(rem); // Create a new node and assign it to current.next
            current = current.next; // Move current to the next node
            rev=rev.next;
        }
         if (carry > 0) {
        current.next = new ListNode(carry); // Add any remaining carry as a new node
    }

    return reverseList(dummy.next); // Reverse the list and return
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
           ListNode ahead=cur.next;
            cur.next=prev;
            prev=cur;
            cur=ahead;
        }
        return prev;
    }    
}
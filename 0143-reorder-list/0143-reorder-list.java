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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // Step 1: Find the middle of the list
            ListNode slow=head;
            ListNode fast=head;
    //jab 2 middle nodes hai and hume 2nd middle node return krna hai (y uska code hai)
             while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
        
      // Step 2: Reverse the second half of the list  
    //   thats why cur m slow ko assign kiya h
         ListNode cur=slow;
        ListNode prev=null;
        while(cur!=null){
           ListNode ahead=cur.next;
            cur.next=prev;
            prev=cur;
            cur=ahead;
        }
          // Step 3: Merge the two halves
        ListNode first = head;
        ListNode second = prev; // 'prev' is now the head of the reversed second half
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            first = temp1;

            second.next = first;
            second = temp2;
        }
    }
}
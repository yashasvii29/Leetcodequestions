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
    public ListNode middleNode(ListNode head) {
         ListNode slow=head;
            ListNode fast=head;
    //jab 2 middle nodes hai and hume 2nd middle node return krna hai (y uska code hai)
             while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        
    }
            /*while(fast.next!=null && fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
    jab 2 middle nodes hai and hume 1st middle node return krna hai (y uska code hai)
            }*/
    
}
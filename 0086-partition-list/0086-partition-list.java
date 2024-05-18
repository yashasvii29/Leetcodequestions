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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0); 
        ListNode l2 = new ListNode(0);  
        ListNode left = l1; 
        ListNode right = l2;  
        ListNode temp = head;
        
        while (temp != null) {
            if (temp.val < x) {
                left.next=new ListNode(temp.val)  ; 
                left = left.next;  
            } else {
                right.next =new ListNode(temp.val) ;
                right = right.next;  
            }
            temp = temp.next;  
        }
        
       
        left.next = l2.next;  
        
        return l1.next;  
    }
}

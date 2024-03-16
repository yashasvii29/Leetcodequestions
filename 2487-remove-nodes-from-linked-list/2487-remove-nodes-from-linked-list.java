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
//  brute force approach which gives tle
// class Solution {
//     public ListNode removeNodes(ListNode head) {
//         ListNode temp1=head;
//         int c=0;// c means length of linked list
//         while(temp1!=null){
//             temp1=temp1.next;
//             c++;
//         }
//         if(c==1){
//             return head;
//         }
//         ListNode dummy=new ListNode();
//         dummy.next=head;
//         ListNode temp=dummy;
//         ListNode slow=temp.next;
//         ListNode fast=temp.next.next;

       
//         while(slow!=null && fast!=null){
//             if(slow.val<fast.val){
//                 temp.next=fast;
//                 slow=fast;
//                 fast=fast.next;
//             }
             
//             else{
//                 fast=fast.next;
//                 if(fast==null)
//                 {
//                 slow=slow.next;
//                 fast=slow.next;
//                 temp=temp.next;
//                 }
//             }
            
           
//         }
//         return dummy.next;
//     }
// }

class Solution {
  public ListNode removeNodes(ListNode head) {
    if (head == null)
      return null;
    head.next = removeNodes(head.next);
    return head.next != null && head.val < head.next.val ? head.next : head;
  }
}
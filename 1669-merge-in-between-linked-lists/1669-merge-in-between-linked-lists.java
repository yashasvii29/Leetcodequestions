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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // a-1 m assign krenge list2 ko and b-1 ko assign krenge list2 ke last node m
            int c1=0;
               ListNode temp1=list2;
        while(temp1!=null){
            temp1=temp1.next;
            c1++;
        }
         ListNode last=GetNode(c1-1,list2);
        
        int ind = a-1;
        ListNode prev = GetNode(ind,list1);
         ind=b+1;
        ListNode ahead=GetNode(ind,list1);
      
         
        prev.next=list2;
        last.next=ahead;
         return list1;
    }



    public ListNode GetNode(int ind,ListNode list){
        ListNode temp = list;
        for(int i=1;i<=ind;i++){
            temp=temp.next;
        }
        return temp;
    }
}
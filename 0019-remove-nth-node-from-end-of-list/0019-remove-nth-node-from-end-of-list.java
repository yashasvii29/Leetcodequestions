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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp=head;
        int c=0;// c means length of linked list
        while(temp!=null){
            temp=temp.next;
            c++;
        }
        if(n==c){// y condition isliye lagayi hai because if n ki value linked list li length ke equal hai means n=5 and ll ki len=5 so hume last se 5th node delete krna means 1st node remove krna hai but isse pehle koi node nhi h to hum prev node ka address nhi nikal sakte (nhi to null pointer exception aayega) isliye y condition apply ki hai
            ListNode tempp=head.next;
            head.next=null;
            return tempp;
        }
        int ind=c-n;// 5-2=3 means 3rd index pr jo node hai use remove krna hai
        ListNode ans=RemoveAtindex(head,ind);
        return ans;
        
    }
    public ListNode RemoveAtindex(ListNode head,int ind){
        ListNode prev=GetNode(head,ind-1);
        ListNode cur=prev.next;
         prev.next=cur.next;
       // cur.next=null;
        return head;
    }
    public ListNode GetNode(ListNode head,int ind){
        ListNode temp=head;
        for(int i=1;i<=ind;i++){
            temp=temp.next;
        }
        return temp;
    }
}
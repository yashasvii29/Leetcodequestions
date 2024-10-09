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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // this que is same as add two numbers but the only differenec iss que m jo 2 linked list gievn h wo reverse order m nhi h(but add to numbers m dono ll reverse order m given thi isliye direct sum find kr rhe the) so dono ll ko reverse krenge and then output m jo l3 linkedlist aayegi usko bhi reverse krenge
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode ans=Add(l1,l2);
        ListNode res = reverseList(ans);
        // res pointer m reverse ll ke 1st node ka address aasign kr rhe h  and res pointer means 1st node ka address return kr rhe h because 1st node ke address se complete ll ko identify kr sakte hai
        return res;

    }
        public ListNode Add(ListNode l1, ListNode l2){
        ListNode l3=new ListNode(0); // ListNode m 0 pass kiya hai means 1 new node banega jisme initially 0 sum hogi
        ListNode head=l3;
        int carry=0;
        while(l1!=null &&l2!=null){
            int sum=l1.val+l2.val+carry;
            carry=sum/10;
            l3.next=new ListNode(sum%10);// l3 le next m new node ka address aa jayega jisme hum ek sum assign kr rhe hai means data sum
            l3=l3.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=l1.val+carry;
            carry=sum/10;
            l3.next=new ListNode(sum%10);
            l3=l3.next;
            l1=l1.next;
        }
        while(l2!=null){
            int sum=l2.val+carry;
            carry=sum/10;
            l3.next=new ListNode(sum%10);
            l3=l3.next;
            l2=l2.next;
        }
        
       if(carry>0){
            l3.next=new ListNode(carry);
        }

        return head.next;
        
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

public class Middle_of_the_LinkedList {
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {

        }
             ListNode(int val) { 
            this.val = val; 
        }
             ListNode(int val, ListNode next)
         {
             this.val = val; 
             this.next = next;
             }
         }
         public ListNode middleNode(ListNode head){
            ListNode slow=head;
            ListNode fast=head;
           /*  This is the code of when we have to return 2nd middle node in the case of 2 middle nodes
           while(fast!=null&& fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }*/
            while(fast.next!=null && fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;

            }
            return slow;
         }
}

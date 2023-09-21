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
    public ListNode mergeKLists(ListNode[] lists) {
        // min heap priority queue banayenge
        // lists m limkedlist hai toh address ko comapre nhi kr sakte ....data ko compare krne ke liye we will use comapator interface toh priority queue m uska object banayenge and comparator interface ke comapre function ko implement krenge to comapre the data
       PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>(){
           @Override
           public int compare(ListNode o1,ListNode o2){
               return o1.val-o2.val;// min heap m o1-o2 and max heap m o2-o1
           }
       
    }); 
       for(ListNode ll:lists){
           if(ll!=null){
               pq.add(ll);
           }
       }
       ListNode Dummy=new ListNode();
       ListNode temp=Dummy;
       while(!pq.isEmpty()){
           ListNode rv=pq.poll();
           Dummy.next=rv;
           Dummy=Dummy.next;
           if(rv.next!=null){
               pq.add(rv.next);
           }
       }
       return temp.next;
    }
}
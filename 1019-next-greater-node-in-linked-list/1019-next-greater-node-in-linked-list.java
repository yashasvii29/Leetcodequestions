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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp=head;
        int c=0;
        while(temp!=null){
            temp=temp.next;
            c++;
        }
        int arr[]=new int[c];
        int p=0;
        while(head!=null){
            arr[p++]=head.val;
            head=head.next;
        }
         int res[]=new int[c];
          Stack<Integer> s=new Stack<>();
          for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[i]>arr[s.peek()]){
                res[s.pop()]=arr[i];
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            res[s.pop()]=0;
        }
        return res;
    }
}










   
        
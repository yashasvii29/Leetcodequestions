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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int c=0;
        ListNode temp=head;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        int arr[]=new int[c];
        int i=0;
        ListNode cur=head;
        while(cur!=null){
            arr[i++]=cur.val;
            cur=cur.next;
        }

        return createTree(arr,0,arr.length-1);
        
    }

     public TreeNode createTree(int in[],int si,int ei){
        if(si>ei){
            return null;
        }
        int mid=(si+ei)/2;
        TreeNode nn=new TreeNode();
        nn.val=in[mid];
        nn.left=createTree(in, si, mid-1);
        nn.right=createTree(in, mid+1, ei);
        return nn;// har frame se root node ka address return kr rhe hai
    }
}
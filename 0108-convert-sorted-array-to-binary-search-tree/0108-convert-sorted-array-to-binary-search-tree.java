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
    public TreeNode sortedArrayToBST(int[] in) {
        return createTree(in,0,in.length-1);

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
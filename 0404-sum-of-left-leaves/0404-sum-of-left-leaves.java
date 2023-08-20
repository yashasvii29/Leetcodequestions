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
    public int sumOfLeftLeaves(TreeNode root) {
        return SumLeaf(root);
    }
    public static int SumLeaf(TreeNode root){
        if(root==null)
            return 0;
        int sum=0;
        if(root.left!=null && root.left.left==null && root.left.right==null)
            sum+=root.left.val;
        int lsum=SumLeaf(root.left);
        int rsum=SumLeaf(root.right);
        return sum+lsum+rsum;
        
    }
}
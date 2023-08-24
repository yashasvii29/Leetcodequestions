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
    public boolean isValidBST(TreeNode root) {
        // bst means inorder traversal 
        return ValidBST(root).isbst;
    }
    public BstPair ValidBST(TreeNode root){
        if(root==null){
            return new BstPair();
        }
        BstPair lbp=ValidBST(root.left);
        BstPair rbp=ValidBST(root.right);
        BstPair sbp=new BstPair();
        sbp.max=Math.max(lbp.max,Math.max(rbp.max,root.val));
        sbp.min=Math.min(root.val,Math.min(lbp.min,rbp.min));
        if(lbp.isbst && rbp.isbst && lbp.max<root.val && rbp.min>root.val){
            sbp.isbst=true;
        }
        else
            sbp.isbst=false;
        return sbp;

        

    }
    class BstPair{
        boolean isbst=true;
        Long min=Long.MAX_VALUE;
        Long max=Long.MIN_VALUE;

    }
}
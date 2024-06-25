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
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        
        convert(root);
        return root;
    }
    public void convert(TreeNode root){
        if(root==null)
            return;
        convert(root.right);
        root.val=root.val+sum;
        sum=root.val;
        convert(root.left);
    }
}
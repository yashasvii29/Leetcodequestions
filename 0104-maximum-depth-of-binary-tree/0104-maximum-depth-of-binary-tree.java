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
    public int maxDepth(TreeNode root) {
         return ht(root)+1;
    }
    public  int ht(TreeNode root){
        if(root==null){
            return -1;// single node ki height 0 aayegi
            // single node ki height 1 aayegi return 0 pe(means 0 return krne pe)
        }
        int lh=ht(root.left);
        int rh=ht(root.right);
        return Math.max(lh,rh)+1;
    
    }
}
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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return ht(root);
    }
   // static int ans=0;
    public  int ht(TreeNode root){
        // single node ki height 0 aayegi
            // single node ki height 1 aayegi return 0 pe(means 0 return krne pe)
        
        if(root.left==null && root.right==null){
            return 1;
        }
        else if(root.left==null){
            return ht(root.right)+1;
        }
        else if(root.right==null){
            return ht(root.left)+1;
        }
         return Math.min(ht(root.right),ht(root.left))+1;
    
    
    }
}
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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // maximum sum ka path return krna hai
      pathSum(root);
      return maxsum;
    }
    public int pathSum(TreeNode root){
        if(root==null)
            return 0;
        int left=Math.max(pathSum(root.left),0);
        int right=Math.max(pathSum(root.right),0);
        maxsum=Math.max(maxsum,left+right+root.val);
        return root.val+Math.max(left,right);
    }
}
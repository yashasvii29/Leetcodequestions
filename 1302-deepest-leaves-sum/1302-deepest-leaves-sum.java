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
    
    public int deepestLeavesSum(TreeNode root) { 
        if(root==null){
            return 0;
        }
        int over_ht=Max(root); // 4
        // System.out.println(over_ht);
        int sum=findSum(root,over_ht,1);
        return sum;
    }

    private int Max(TreeNode root){
        if(root==null){
            return 0;
        }
    // consider leaf node has 0 height
        int left=Max(root.left);
        int right=Max(root.right);
        return Math.max(left,right)+1;

    }
    
    private int findSum(TreeNode root,int ht,int curlev){
         if(root==null){
            return 0;
        }
         if(curlev==ht){
            return root.val;
        }
        
        int lfsum= findSum(root.left,ht,curlev+1);
        int rtsum= findSum(root.right,ht,curlev+1);
        return lfsum+rtsum;
        
    }
}
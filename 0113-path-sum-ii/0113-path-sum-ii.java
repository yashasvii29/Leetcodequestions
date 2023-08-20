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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> ans=new ArrayList<>();
       List<Integer> ls=new ArrayList<>();
       hasPathSum(root,targetSum,ls,ans);
       return ans; 
    }
    public void hasPathSum(TreeNode root, int targetSum,List<Integer> ls,List<List<Integer>> ans){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null && targetSum-root.val==0){
            ls.add(root.val);
            ans.add(new ArrayList<Integer>(ls));
            ls.remove(ls.size()-1);
        }
        ls.add(root.val);
        hasPathSum(root.left,targetSum-root.val,ls,ans);
        hasPathSum(root.right,targetSum-root.val,ls,ans);
        ls.remove(ls.size()-1);

    }
}
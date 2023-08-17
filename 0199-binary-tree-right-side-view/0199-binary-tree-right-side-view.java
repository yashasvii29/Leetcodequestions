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
    int maxdepth=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        rightView(root,1,ll);
        return ll;
    }
    public void  rightView(TreeNode root,int curlevel,List<Integer> ll){
        if(root==null){
            return;
        }
       if(maxdepth<curlevel){
           ll.add(root.val);
           maxdepth=curlevel;
       }
       rightView(root.right,curlevel+1,ll);
       rightView(root.left,curlevel+1,ll);
    }

}
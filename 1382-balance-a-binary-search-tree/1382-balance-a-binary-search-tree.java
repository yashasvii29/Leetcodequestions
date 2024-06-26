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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> ll=new ArrayList<>();
        InOrder(root,ll);
         return sortedArrayToBST(0, ll.size() - 1,ll);
    }
      public void InOrder(TreeNode root,ArrayList<TreeNode> ll) {     
         if(root==null){
            return ;
        }
        InOrder(root.left,ll);
        ll.add(root);
        InOrder(root.right,ll);   
    
    }
    public TreeNode sortedArrayToBST(int start, int end,ArrayList<TreeNode> ll){
        if (start > end) 
            return null;
        int mid = (start + end) / 2;
        TreeNode root = ll.get(mid);
        root.left = sortedArrayToBST(start, mid - 1,ll);
        root.right = sortedArrayToBST(mid + 1, end,ll);
        return root;
    }
}
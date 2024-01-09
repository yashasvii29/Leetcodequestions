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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ls1=new ArrayList<>();
        List<Integer> ls2=new ArrayList<>();
        check1(root1,ls1);
        check2(root2,ls2);
        if(ls1.size()>ls2.size() || ls1.size()<ls2.size()){
            return false;
        }
        for(int i=0;i<ls1.size();i++){
            if(ls1.get(i)==ls2.get(i)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;

    }
    private void check1(TreeNode root,List<Integer> ls1){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            ls1.add(root.val);
        }
        check1(root.left,ls1);
        check1(root.right,ls1);

    }
    private void check2(TreeNode root,List<Integer> ls2){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            ls2.add(root.val);
        }
        check2(root.left,ls2);
        check2(root.right,ls2);

    }

}
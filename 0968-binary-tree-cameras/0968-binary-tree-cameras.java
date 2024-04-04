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
    public int minCameraCover(TreeNode root) {
        count=0;
        int x=Camera(root);
        if(x==-1){
            return count+1;
        }
        return count;


    }
    int count=0;
    public int Camera(TreeNode root){
        if(root==null){
            return 0;//covered
        }
        int left=Camera(root.left);
        int right=Camera(root.right);
        if(left==-1 ||  right==-1){
            count++;
            return 1;//camera setup
        }
        else if(left==1 ||  right==1){
            return 0;//if any of the child is covered return covered
        }
        else{
            return -1;
        }

    }
}
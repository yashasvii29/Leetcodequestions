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
    public void flatten(TreeNode root) {
          if (root == null) return;
        
        // Flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Store the right subtree
        TreeNode tempRight = root.right;

        // Move the left subtree to the right
        root.right = root.left;
        root.left = null;

        // Attach the original right subtree to the end of the new right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = tempRight;
    }
}
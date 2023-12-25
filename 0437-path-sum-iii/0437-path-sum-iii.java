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
    public int pathSum(TreeNode root, int targetSum) {
      return display(root, targetSum, new ArrayList<>(), 0);
    }

    private int display(TreeNode root, int targetSum, ArrayList<TreeNode> path, long currentSum) {
        if (root == null) {
            return 0;
        }

        path.add(root);
        currentSum += root.val;

        int count = 0;
        long sum = 0;

        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).val;
            if (sum == targetSum) {
                count++;
            }
        }

        count += display(root.left, targetSum, path, currentSum);
        count += display(root.right, targetSum, path, currentSum);

        // Backtrack: Remove the current node from the path and subtract its value from currentSum
        path.remove(path.size() - 1);
        currentSum -= root.val;

        return count;
    }

    
}
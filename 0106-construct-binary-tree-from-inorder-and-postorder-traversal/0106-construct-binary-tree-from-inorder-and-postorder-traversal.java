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
    public TreeNode buildTree(int[] inorder , int[] postorder) {
         return Create(inorder, 0 , inorder.length - 1, postorder, 0, postorder.length - 1);

		}

		private TreeNode Create(int[] inorder, int ilo, int ihi, int[] postorder, int plo, int phi) {
			// TODO Auto-generated method stub
			if (ilo > ihi || plo > phi) {
				return null;
			}
			
			TreeNode nn = new TreeNode(postorder[phi]);
			if(ilo==ihi || plo==phi){
				return nn;
			}
			int i = Search(inorder, ilo, ihi, postorder[phi]);
			int nel = i - ilo;
			nn.left = Create( inorder, ilo, i - 1,postorder, plo, nel-1+plo);
			nn.right = Create(inorder, i + 1, ihi,postorder, plo + nel, phi-1);
			return nn;

		}

		public int Search(int[] inorder, int si, int ei, int item) {

			for (int i = si; i <= ei; i++) {
				if (inorder[i] == item) {
					return i;
				}
			}
			return -1;

		}
    
}
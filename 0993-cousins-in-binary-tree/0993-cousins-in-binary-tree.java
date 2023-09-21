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
    public boolean isCousins(TreeNode root, int x, int y) {
        // two node cousin tabhi honge jab wo same level pr honge but they have different parents
        Queue<TreeNode> q=new LinkedList<>();
       q.add(root);
       q.add(null);
        while(!q.isEmpty()){
      ArrayList<Integer> list = new ArrayList<>();
           TreeNode curr=q.poll();
           // poll() queue ke front se remove krta hai

           while(curr!=null){
               list.add(curr.val);

               if(curr.left!=null){
                   q.add(curr.left);
               }
                if(curr.right!=null){
                   q.add(curr.right);
               }
               if(curr.left!=null && curr.right!=null)
               {
                if((curr.left.val==x && curr.right.val ==y) ||(curr.left.val==y && curr.right.val ==x))
                {
                    return false;
                }
            }
               curr=q.poll();
           }
            if(q.size()>=1){
              q.add(null);
            }
           if(list.contains(x) && list.contains(y)){
               return true;
           }
        }
        return false;
       
    }
}
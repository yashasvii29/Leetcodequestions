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
    public int findBottomLeftValue(TreeNode root) {
       List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.val;
        }
        levelOrr(root,ans);
        List<Integer> hlp=ans.get(ans.size()-1);
        return hlp.get(0);
    }
    public static  void levelOrr(TreeNode root, List<List<Integer>> ans){
        // LinkedList<Node> queue=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
        // hum ek queue banayenge jisme nodes ke address honge and right side m LinkedList likhenge because node ko linkedlist ke through connect karenge
        // 2nd case of inheritance 
        q.add(root);
        while(!q.isEmpty()){
            //// remove first
            //q.poll()
            int size=q.size();
            List<Integer> obj=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode rv=q.remove();
                 if(rv.left!=null){
                q.add(rv.left);
                
            }
            if(rv.right!=null){
                q.add(rv.right); 
            }
            obj.add(rv.val);
           
        }
           ans.add(obj);
            
        }
       
    } 
    
}
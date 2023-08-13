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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        levelOrr(root,ans);
        return ans;
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
      for(int i=1;i<ans.size();i+=2){
              ans.set(i,reverse(ans.get(i)));
           
      } 
    }
    public static List<Integer> reverse(List<Integer> ls){
        List<Integer> hlp=new ArrayList<>();
        for(int i=ls.size()-1;i>=0;i--){
            hlp.add(ls.get(i));

        }
        return hlp;
    }
    
}
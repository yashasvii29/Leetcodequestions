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
    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> hlp=new ArrayList<>();
        if(root==null){
            return hlp;
        }
        if(root.left==null && root.right==null){
            hlp.add(root.val);
            return hlp;
        }
        levelOrr(root,ans);
       
        for(int i=0;i<ans.size();i++){
            List<Integer> b=ans.get(i);
             Collections.sort(b);
             hlp.add(b.get(b.size()-1));
            }
        return hlp;
        
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
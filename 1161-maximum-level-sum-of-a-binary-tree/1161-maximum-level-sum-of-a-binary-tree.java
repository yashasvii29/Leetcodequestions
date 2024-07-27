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
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return 0;
        }
        levelOrr(root,ans);
        List<Integer> ll=new ArrayList<>();
        int size=ans.size();
        for(int i=0;i<ans.size();i++){
            List<Integer> temp=ans.get(i);
            int sum=0;
            int j=0;
            while(j<temp.size()){
                sum+=temp.get(j);
                j++;
            }
            ll.add(sum);
        }
        int max=Integer.MIN_VALUE;
    int ind=0;
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)>max){
                max=ll.get(i);
                ind=i+1;
            }
        }
        return ind;
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
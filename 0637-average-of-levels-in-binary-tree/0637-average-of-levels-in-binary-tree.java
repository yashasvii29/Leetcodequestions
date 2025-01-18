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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ll=new ArrayList<>();
       List<List<Integer>> ans=levelOrder(root);
      
        for(List<Integer> a:ans){
         
            long sum=0;
            for(int val:a){
                sum+=val;
            }
            double avg = (double)sum/(a.size());
            
            ll.add(avg);

        }
        return ll;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {  
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
            int size=q.size(); // 2d list m ans return krna h that'why  q ka size find krenge
            List<Integer> ll=new ArrayList<>();
            while(size-->0){
                TreeNode rv=q.remove(); // remove 
                 ll.add(rv.val); // print
                //  add
                 if(rv.left!=null){
                q.add(rv.left);
                
            }
            if(rv.right!=null){
                q.add(rv.right); 
            }
           
           
        }
           ans.add(ll);
            
        }
       
    }
}
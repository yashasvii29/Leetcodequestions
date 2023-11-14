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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        // treemap isliye banaya hai jisse keys sorted rahe
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair cur=q.remove();
            TreeNode node=cur.node;
            int x=cur.row;
            // x means horizontal dis
            // y means vertical distance
            int y=cur.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).add(node.val);
            if(node.left!=null){
                q.add(new Pair(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,x+1,y+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ll:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq:ll.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.remove());
                    
                }
               
            }
        }
        return ans;
    }
}
class Pair{
    TreeNode node;
    int row;
    int col;

    public Pair(TreeNode node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
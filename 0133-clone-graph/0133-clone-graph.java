/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        HashMap<Node,Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.put(node,new Node(node.val));
        while(!q.isEmpty()){
            Node p = q.poll();
            for(Node nbrs:p.neighbors){
                if(!visited.containsKey(nbrs)){
                   visited.put(nbrs,new Node(nbrs.val));
                    q.add(nbrs);
                }
                 visited.get(p).neighbors.add(visited.get(nbrs));
            }
        }
        return visited.get(node);
    }
}
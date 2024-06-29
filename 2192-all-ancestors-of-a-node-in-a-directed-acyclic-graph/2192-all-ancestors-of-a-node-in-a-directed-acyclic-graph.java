class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; ++i)  adjList.add(new ArrayList<>());
        for(int edge[] : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++)  ans.add(new ArrayList<>());
        for(int i=0; i<n; i++)  dfs(i, i, new boolean[n],ans,adjList);

        return ans;
    }

    private void dfs(int curNode, int root, boolean vis[],  List<List<Integer>> ans,List<List<Integer>> adjList) {
        if(curNode != root && !vis[curNode])
                 ans.get(curNode).add(root);
        vis[curNode] = true;
        for(int adjNode : adjList.get(curNode)) {
            if(!vis[adjNode]) {
                dfs(adjNode, root, vis,ans,adjList);
            }  
        }
        
    }
}
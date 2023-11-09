class Solution {
    public boolean isBipartite(int[][] graph) {
        // acyclic graph always bipartite graph hota hai 
        // even length ka cycle always bipartite hota hai
        // odd len ka cycle never be bipartite
        // cyclic graph m ek bhi odd len ka cycle mil gya then the given graph is not a bipartite graph
        // we will use bft algorithm in this que
        // jagged array ki form m input

        HashMap<Integer,Integer> visited=new HashMap<>();
        Queue<BipartitePair> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new BipartitePair(i,0));
            while(!q.isEmpty()){
                BipartitePair rp=q.poll();
                if(visited.containsKey(rp.vtx)){
                    if(visited.get(rp.vtx)!=rp.des){
                        return false;
                    }
                    continue;
                }
                visited.put(rp.vtx,rp.des);
                for(int nbrs:graph[rp.vtx]){
                    if(!visited.containsKey(nbrs)){
                        q.add(new BipartitePair(nbrs,rp.des+1));
                    }
                }
            }
            
        }
        return true;
    }
}


class BipartitePair{
    int vtx;
    int des;
    public BipartitePair(int vtx,int des){
        this.vtx=vtx;
        this.des=des;
    }
}
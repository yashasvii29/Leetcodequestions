class Solution {
    public int findCenter(int[][] edges) {
        int ans=0;
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[0].length;j++){
                int val=edges[i][j];
                map.put(val,map.getOrDefault(val,0)+1);
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)==edges.length){
                ans=key;
                break;
            }
        }
        return ans;
    }
}
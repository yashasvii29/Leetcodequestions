class Solution {
    public long maximumImportance(int n, int[][] roads) {
      int degree[]=new int[n];
      for(int a[]:roads){
        int u=a[0];
        int v=a[1];
        degree[u]++;
        degree[v]++;
      }
      Arrays.sort(degree);
      long ans=0,val=1;
      for(int key:degree){
        ans+=key*val;
        val++;
      }
      return ans;
    }
}
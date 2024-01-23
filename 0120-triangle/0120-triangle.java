class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
       int dp[][]=new int[n][n];
       for(int a[]:dp){
           Arrays.fill(a,-1);
       }
       return findSum(triangle,0,0,n,dp);
    }
    public int findSum(List<List<Integer>> triangle,int i,int j,int n,int dp[][]){
        if(i==n-1){
            return triangle.get(n-1).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int first = findSum(triangle,i+1,j,n,dp);
        int second = findSum(triangle,i+1,j+1,n,dp);
        return dp[i][j]=triangle.get(i).get(j)+Math.min(first,second);

    }
}
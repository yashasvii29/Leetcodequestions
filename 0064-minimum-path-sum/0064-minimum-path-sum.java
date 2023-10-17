class Solution {
    public int minPathSum(int[][] grid) {
       int dp[][]=new int[grid.length][grid[0].length];
       for(int a[]:dp){
           Arrays.fill(a,-1);
       }
       return minpathsum(grid,0,0,dp);
    }
    public static int minpathsum(int grid[][],int i,int j,int dp[][]){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int v =minpathsum(grid,i+1,j,dp);
        int h =minpathsum(grid,i,j+1,dp);
        dp[i][j]=grid[i][j]+Math.min(v,h);
        return grid[i][j]+Math.min(v,h);
    }
}
class Solution {
    public boolean stoneGame(int[] piles) {


        // this que is same as optimal game in vscode
         int dp[][]=new int[piles.length][piles.length];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
         OptimalGame_Strategy(piles, 0, piles.length-1,dp);
         
         return dp[0][piles.length-1]>0;
    }
      public static int OptimalGame_Strategy(int  piles[],int i,int j,int dp[][]){

        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int f=piles[i]+Math.min(OptimalGame_Strategy( piles, i+2, j,dp),OptimalGame_Strategy( piles, i+1, j-1,dp));
        int s=piles[j]+Math.min(OptimalGame_Strategy( piles, i+1, j-1,dp),OptimalGame_Strategy( piles, i, j-2,dp));
        dp[i][j]=Math.max(f,s);
        return Math.max(f,s);


    }
}
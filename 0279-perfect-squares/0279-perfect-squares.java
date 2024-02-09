class Solution {
    public int numSquares(int n) {
       int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return solveMemo(n,dp);
    }
     public int solveMemo(int n,int[] dp){
        if(n == 0)
            return 0;
        if(dp[n] != Integer.MAX_VALUE){
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1; i*i <= n ;i++){
            ans = Math.min(ans,solveMemo(n-i*i,dp)+1);
        }
        
        return dp[n] = ans;
    }

}
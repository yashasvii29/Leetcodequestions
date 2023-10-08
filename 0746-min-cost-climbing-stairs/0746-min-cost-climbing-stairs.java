class Solution {
    public int minCostClimbingStairs(int[] cost) {

       int dp[]=new int[cost.length];
       Arrays.fill(dp,-1);
       return Helper(cost,dp);
    }
    public static int Helper(int arr[],int dp[]){
        int f=mincost(arr,0,dp);
        int s=mincost(arr,1,dp);
        return Math.min(f,s);

    }
    public static int mincost(int arr[],int i,int dp[]){

        if(i>=arr.length)
            return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int first=mincost(arr,i+1,dp);
        int sec=mincost(arr,i+2,dp);
        dp[i]=Math.min(sec,first)+arr[i];
        return Math.min(sec,first)+arr[i];
    }
}
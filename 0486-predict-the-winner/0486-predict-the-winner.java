class Solution {
    public boolean predictTheWinner(int[] nums) {
        // hackerblocks que 
        // optimal game stategy
         int dp[][]=new int[nums.length][nums.length];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
         int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int player1Score = OptimalGame_Strategy(nums, 0, nums.length - 1, dp);
        int player2Score = totalSum - player1Score;
        return player1Score >= player2Score;
    }
    public static int OptimalGame_Strategy(int nums[],int i,int j,int dp[][]){

        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int f=nums[i]+Math.min(OptimalGame_Strategy(nums, i+2, j,dp),OptimalGame_Strategy(nums, i+1, j-1,dp));
        int s=nums[j]+Math.min(OptimalGame_Strategy(nums, i+1, j-1,dp),OptimalGame_Strategy(nums, i, j-2,dp));
        
        return dp[i][j]=Math.max(f,s);

    }
}